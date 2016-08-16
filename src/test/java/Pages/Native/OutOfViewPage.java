/*
 * Copyright 2014-2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
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
import org.openqa.selenium.WebElement;

/**
 * A page for a element hidden from the screen inside a scrollview
 */
public class OutOfViewPage extends BasePage {
    /**
     * The scrollview
     */
    @AndroidFindBy(className = "android.widget.ScrollView")
    private MobileElement scrollView;

    public OutOfViewPage(AppiumDriver driver) {
        super(driver);
    }

    /**
     *
     * @return if the hidden element is displayed
     */
    public boolean isHiddenTextDisplayed() {
        WebElement outOfViewText = driver.findElementByName("This is hidden text");
        return outOfViewText.isDisplayed();
    }

    /**
     * Scrolls to the bottom of the scrollview
     */
    public void scrollDownToHiddenText() {
        try {
            scrollView.swipe(SwipeElementDirection.UP, 10, 10, 1000);
            scrollView.swipe(SwipeElementDirection.UP, 10, 10, 1000);
            scrollView.swipe(SwipeElementDirection.UP, 10, 10, 1000);
        } catch (Exception e) {} // Catch "The swipe did not complete successfully" error
    }
}
