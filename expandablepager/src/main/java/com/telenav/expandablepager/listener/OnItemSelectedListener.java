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

import java.util.List;

/**
 * Listener for ViewPager page selected events
 */
public interface OnItemSelectedListener {
    /**
     * Fires each time a page from the ViewPages is selected
     * @param items list of adapter items
     * @param index index of the selected item
     */
    void onItemSelected(List<?> items, int index);
}
