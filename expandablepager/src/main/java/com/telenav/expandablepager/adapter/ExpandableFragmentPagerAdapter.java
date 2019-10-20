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

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;

import com.telenav.expandablepager.ExpandablePager;

import java.util.List;

/**
 * FragmentPagerAdapter for ExpandablePager. Extend this class and pass it to your pager via {@link ExpandablePager#setAdapter(PagerAdapter)}
 */
public abstract class ExpandableFragmentPagerAdapter<T> extends FragmentPagerAdapter {

    protected List<T> items;

    public ExpandableFragmentPagerAdapter(FragmentManager fm, List<T> items) {
        super(fm);
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    public List<T> getDataItems() {
        return items;
    }
}
