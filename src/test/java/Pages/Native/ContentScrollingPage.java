/*
 * Copyright 2014-2066 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 * http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package Pages.Native;

import Pages.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * A page for a scroll view
 */
public class ContentScrollingPage extends BasePage {
    /**
     * Scroll view
     */
    @AndroidFindBy(className = "android.widget.ScrollView")
    private MobileElement scrollView;

    public ContentScrollingPage(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Scroll down
     */
    public void scrollDown(){
        scrollView.swipe(SwipeElementDirection.UP, 10, 10, 10000);
    }

    /**
     *
     * @return if the scrollview is displayed
     */
    public boolean scrollViewDisplayed(){
        return scrollView.isDisplayed();
    }
}
