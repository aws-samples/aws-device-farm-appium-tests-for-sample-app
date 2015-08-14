/*
 * Copyright 2014-2015 Amazon.com, Inc. or its affiliates. All Rights Reserved.
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

package Pages.Inputs;

import Pages.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

/**
 * A page for a pull to refresh control
 */
public class PullToRefreshPage extends BasePage
{
    /**
     * The scrollview
     */
    @AndroidFindBy(id = "input_refresh_scrollview")
    private MobileElement scrollView;

    /**
     * The display
     */
    @AndroidFindBy(id = "input_refresh_display")
    private MobileElement display;

    public PullToRefreshPage(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Pulls down to refresh
     */
    public void pullToRefresh() {
        scrollView.swipe(SwipeElementDirection.DOWN, 10, 10, 100);
    }

    /**
     *
     * @return the display text
     */
    public String getDisplayText(){
        return display.getText();
    }
}
