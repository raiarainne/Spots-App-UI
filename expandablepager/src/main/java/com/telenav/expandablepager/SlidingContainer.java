/**
 * © 2016 Telenav, Inc.  All Rights Reserved
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License").
 * <p/>
 * You may not use this file except in compliance with the License. You may obtain a copy of the
 * License at http://www.apache.org/licenses/LICENSE-2.0. Unless required by applicable law or
 * agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for
 * the specific language governing permissions and limitations under the License.
 */

package com.telenav.expandablepager;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.support.annotation.IntDef;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import com.telenav.expandablepager.listener.OnSlideListener;

/**
 * Container that slides vertically between provided slide values.
 */
public class SlidingContainer extends RelativeLayout {

    public static final int STATE_COLLAPSED = 0, STATE_EXPANDED = 1, STATE_HIDDEN = -1;
    private static final int SLIDE_THRESHOLD_DIPS = 20;
    private final float DEFAULT_SLIDE_THRESHOLD;
    /**
     * Each slide event must pass this threshold in order not to be ignored.
     */
    private float slideThreshold;
    private int viewHeight;
    /**
     * The container will stop sliding when it reaches one of the stopValues.
     */
    private List<Float> stopValues = new ArrayList<>();
    private int stopValueIndex = 0;
    private float startYCoordinate;
    /**
     * Difference between start touch Y coordinate and current Y coordinate.
     */
    private float touchDelta;
    /**
     * Current translationY value
     */
    private float translated = 0;
    private OnSlideListener slideListener;
    private int duration = 200;

    public SlidingContainer(Context context) {
        super(context);
        slideThreshold = context.getResources().getDisplayMetrics().density * SLIDE_THRESHOLD_DIPS;
        DEFAULT_SLIDE_THRESHOLD = slideThreshold;
    }

    public SlidingContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
        slideThreshold = context.getResources().getDisplayMetrics().density * SLIDE_THRESHOLD_DIPS;
        DEFAULT_SLIDE_THRESHOLD = slideThreshold;
    }

    public void setSlideListener(OnSlideListener slideListener) {
        this.slideListener = slideListener;
    }

    public void setAnimationDuration(int duration) {
        this.duration = duration;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (viewHeight == 0) {
            viewHeight = h;
            Iterator<Float> iter = stopValues.iterator();
            while (iter.hasNext()) {
                Float i = iter.next();
                if (i >= viewHeight || i < 0)
                    iter.remove();
            }
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return !translate(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        translate(event);
        return true;
    }

    protected void enableSlide(boolean enable) {
        slideThreshold = enable ? DEFAULT_SLIDE_THRESHOLD : Integer.MAX_VALUE;
    }

    private boolean translate(MotionEvent ev) {
        final int action = MotionEventCompat.getActionMasked(ev);
        int stepSize = stopValues.size();

        switch (action) {
            case MotionEvent.ACTION_DOWN: {
                startYCoordinate = ev.getRawY();
                translated = 0;
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                touchDelta = (startYCoordinate - ev.getRawY());
                if (Math.abs(touchDelta) > slideThreshold) {
                    float startingPointY, nextPointY, maxDiff, tempDelta, auxDelta = 0;
                    tempDelta = touchDelta + (touchDelta < 0 ? 1 : -1) * slideThreshold;
                    startingPointY = stopValues.get(stopValueIndex);
                    if (!isUpwardGesture() && stopValueIndex >= 1) {
                        nextPointY = stopValues.get(stopValueIndex - 1);
                        maxDiff = nextPointY - stopValues.get(stopValueIndex);
                        auxDelta = Math.min(-tempDelta, maxDiff);
                    } else if (isUpwardGesture() && stopValueIndex < stepSize - 1) {
                        nextPointY = stopValues.get(stopValueIndex + 1);
                        maxDiff = nextPointY - stopValues.get(stopValueIndex);
                        auxDelta = Math.max(-tempDelta, maxDiff);
                    }
                    float preTranslated = translated;
                    translated = startingPointY + auxDelta;
                    setTranslationY(translated);
                    if (preTranslated != translated)
                        notifySlideEvent(translated);
                    return false;
                }
                return true;
            }
            case MotionEvent.ACTION_UP: {
                if (Math.abs(touchDelta) > slideThreshold) {
                    if (!isUpwardGesture() && stopValueIndex > 0)
                        stopValueIndex--;
                    else if (isUpwardGesture() && stopValueIndex < stepSize - 1)
                        stopValueIndex++;
                    if (!stopValues.contains(translated)) {
                        animate(stopValues.get(stopValueIndex));
                    } else
                        onSettled(stopValueIndex);
                    startYCoordinate = -1;
                    touchDelta = 0;
                }
                break;
            }
            case MotionEvent.ACTION_CANCEL: {
                break;
            }
            case MotionEvent.ACTION_POINTER_UP: {
                break;
            }
        }
        return true;
    }

    protected void onSettled(int slideValueIndex) {
    }

    /**
     * indicates that that the finger moved up
     */
    private boolean isUpwardGesture() {
        return touchDelta > 0;
    }

    /**
     * Convenience method, uses FastOutSlowInInterpolator and default animation duration. See {@link SlidingContainer#animate(float, int, Interpolator)}
     * @param amount translationY amount
     */
    private void animate(float amount) {
        animate(amount, duration, new LinearInterpolator());
    }

    /**
     * Convenience method, uses FastOutSlowInInterpolator. See {@link SlidingContainer#animate(float, int, Interpolator)}
     * @param amount translationY amount
     * @param duration animation duration
     */
    private void animate(float amount, int duration) {
        animate(amount, duration, new FastOutSlowInInterpolator());
    }

    /**
     * Animate translationY to the next stopValue
     * @param amount translationY amount
     * @param duration animation duration
     * @param interpolator  animation interpolator
     */
    private void animate(final float amount, int duration, Interpolator interpolator) {
        ObjectAnimator oa = ObjectAnimator.ofFloat(this, View.TRANSLATION_Y, amount)
                .setDuration(duration);
        oa.setInterpolator(interpolator);
        oa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                notifySlideEvent(Math.round(((Float) animation.getAnimatedValue())));
            }
        });
        oa.addListener(new CustomAnimationListener() {
            @Override
            public void onAnimationEnd(Animator animator) {
                onSettled(stopValueIndex);
            }
        });
        oa.start();
    }

    public List<Float> getStopValues() {
        return stopValues;
    }

    /**
     * Stops sliding at the specified values.
     * @param stopValues list of stop values
     */
    public void setStopValues(Float... stopValues) {
        SortedSet<Float> s = new TreeSet<>(Collections.reverseOrder());
        s.addAll(Arrays.asList(stopValues));
        this.stopValues.clear();
        this.stopValues.addAll(s);
        this.stopValues.add(0f);
        stopValueIndex = 0;
    }

    public Float getCurrentStopValue() {
        return stopValues.get(stopValueIndex);
    }

    /**
     * Sets the container position to a given state. No animation occurs. For an animated alternative see {@link SlidingContainer#animateToState(int, int)}
     */
    public boolean setState(@SliderState int state) {
        if (!stopValues.isEmpty())
            switch (state) {
                case STATE_COLLAPSED:
                    setTranslationY(stopValues.get(0));
                    stopValueIndex = 0;
                    return true;
                case STATE_EXPANDED:
                    setTranslationY(0);
                    stopValueIndex = stopValues.size() - 1;
                    return true;
                case STATE_HIDDEN:
                    setTranslationY(getHeight());
                    return true;
            }
        return false;
    }

    /**
     * Convenience method, uses default duration. See {@link SlidingContainer#animateToState(int, int)}
     */
    public boolean animateToState(@SliderState int toState) {
        return animateToState(toState, duration);
    }

    /**
     * Animate the container position to a given state. For a non-animated alternative see {@link SlidingContainer#setState(int)}
     */
    public boolean animateToState(@SliderState int toState, int duration) {
        if (!stopValues.isEmpty()) {
            switch (toState) {
                case STATE_COLLAPSED:
                    animate(stopValues.get(0), duration);
                    stopValueIndex = 0;
                    return true;
                case STATE_EXPANDED:
                    animate(0, duration);
                    stopValueIndex = stopValues.size() - 1;
                    return true;
                case STATE_HIDDEN:
                    animate(getHeight(), duration);
                    return true;
            }
        }
        return false;
    }

    protected void notifySlideEvent(float yPosition) {
        if (slideListener != null) {
            slideListener.onSlide(yPosition);
        }
    }

    public @SliderState int getState() {
        int translation = (int) getTranslationY();
        if (translation == 0)
            return STATE_EXPANDED;
        else if (translation == viewHeight)
            return STATE_HIDDEN;
        else if (stopValues.size() >= 2 && translation == stopValues.get(stopValues.size() - 2))
            return STATE_COLLAPSED;
        return STATE_COLLAPSED;//check this later
    }

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({STATE_COLLAPSED, STATE_EXPANDED, STATE_HIDDEN})
    public @interface SliderState {
    }

    private static class CustomAnimationListener implements Animator.AnimatorListener {
        @Override
        public void onAnimationStart(Animator animator) {

        }

        @Override
        public void onAnimationEnd(Animator animator) {

        }

        @Override
        public void onAnimationCancel(Animator animator) {

        }

        @Override
        public void onAnimationRepeat(Animator animator) {

        }
    }
}