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

package com.telenav.expandablepager.listener;

import android.view.View;

import com.telenav.expandablepager.SlidingContainer;

/**
 * Listener for slider state change events
 */
public interface OnSliderStateChangeListener {
    /**
     * Fires when slider state changes as a result of a slide. Ex: change from expanded state to collapsed state.
     *
     * @param page  view linked with the page whose state being changed
     * @param index page index
     * @param state new slider state
     */
    void onStateChanged(View page, int index, @SlidingContainer.SliderState int state);

    /**
     * Fires when the state changes for a page different from the current page (most often the next page offscreen) or when the view size changes
     *
     * @param page  view linked with the page whose state being changed
     * @param index page index
     * @param state new slider state
     */
    void onPageChanged(View page, int index, @SlidingContainer.SliderState int state);
}
