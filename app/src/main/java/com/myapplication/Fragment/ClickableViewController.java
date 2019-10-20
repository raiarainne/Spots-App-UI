/*
 * ClickableViewController.java
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.myapplication.Fragment;

import android.view.View;

/**
 * This interface enforces the fact that classes implementing it can accept click events on sub views contained
 * within the view group.
 * <p/>
 * Created by joseluisugia on 01/10/15.
 */
public interface ClickableViewController {

    void buttonClicked(View view);
}
