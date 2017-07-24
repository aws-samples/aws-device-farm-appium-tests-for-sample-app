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

package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

/**
 * Nested Views Page
 */
public class NestedViewsPage extends BasePage {
    /**
     * Up option button
     */
    @AndroidFindBy(id = "com.amazonaws.devicefarm.android.referenceapp:id/nested_up_button")
    private MobileElement upButton;

    /**
     * Back option button
     */
    @AndroidFindBy(id = "com.amazonaws.devicefarm.android.referenceapp:id/nested_back_button")
    private MobileElement backButton;

    public NestedViewsPage(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Press the back button category
     */
    public void pressBackButtonCategory() {
        backButton.click();
    }

    /**
     * Press the up button category
     */
    public void pressUpButtonCategory() {
        upButton.click();
    }

    /**
     *
     * @return up message text
     */
    public String getUpMessage() {
        List textViews = driver.findElementsByClassName("android.widget.TextView");
        return ((MobileElement) textViews.get(textViews.size() - 1)).getText();
    }

    /**
     * Presses the next button
     */
    public void pressNextUpButton() {
        driver.findElementById("com.amazonaws.devicefarm.android.referenceapp:id/nested_up_button").click();
    }

    /**
     * Presses the up button in the toolbar
     */
    public void navigateUp() {
        driver.findElementByAccessibilityId("Navigate up").click();
    }

    /**
     * Presses the back button
     */
    public void pressBackButton() {
        driver.navigate().back();
    }

    /**
     * Presses the next button
     */
    public void pressNextBackButton() {
        driver.findElementById("com.amazonaws.devicefarm.android.referenceapp:id/back_navigation_next_button").click();
    }

    /**
     *
     * @return the counter text
     */
    public String getCounter() {
        return driver.findElementByAccessibilityId("Level Display").getText();
    }
}
