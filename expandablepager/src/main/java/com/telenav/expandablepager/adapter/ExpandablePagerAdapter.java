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

package com.telenav.expandablepager.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.telenav.expandablepager.ExpandablePager;
import com.telenav.expandablepager.R;

import java.util.List;

/**
 * PagerAdapter for ExpandablePager. Extend this class and pass it to your pager via {@link ExpandablePager#setAdapter(PagerAdapter)}
 */
public class ExpandablePagerAdapter<T> extends PagerAdapter {

    protected List<T> items;

    public ExpandablePagerAdapter(List<T> items) {
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    public List<T> getDataItems() {
        return items;
    }

    /**
     * Attaches the view to the container and gives it a specific id. Return the result of this method when overriding {@link #instantiateItem(ViewGroup, int)}
     * @param container view container
     * @param v inflated view
     * @param position position of the view in the adapter
     * @return inflated view
     */
    protected View attach(ViewGroup container, View v, int position) {
        v.setId(R.id.internal_page_id % 10000 + position);
        container.addView(v);
        return v;
    }
}
