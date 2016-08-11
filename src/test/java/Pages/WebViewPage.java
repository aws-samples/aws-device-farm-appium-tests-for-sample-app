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

package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

/**
 * A page for a web view
 */
public class WebViewPage extends BasePage{
    private static final String NAV_BAR_SELECTOR = "new UiSelector().textContains(\"http://www.amazon.com\")";
    private static final String FOCUSED_WEB_VIEW_SELECTOR = "new UiSelector().focused(true).descriptionContains(\"aws\")";
    private static final int KEYBOARD_ANIMATION_DELAY = 1000;
    private static final int WEBSITE_LOAD_TIME = 7000;

    /**
     * the web view input
     */
    @AndroidFindBy(uiAutomator = NAV_BAR_SELECTOR)
    private MobileElement webViewInput;

    /**
     * the web view input
     */
    @AndroidFindBy(uiAutomator = FOCUSED_WEB_VIEW_SELECTOR)
    private MobileElement loadedWebView;

    public WebViewPage(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Helper function that taps screen's center once.
     */
    private void tapScreenCenter() {
        Dimension screenSize = driver.manage().window().getSize();
        int midX = screenSize.getWidth() / 2;
        int midY = screenSize.getHeight() / 2;

        driver.tap(1, midX, midY, 1);
    }

    /**
     * Has to be in this format: "http://www.amazon.com"
     * @param url the web address
     */
    public void gotoUrl(String url) throws InterruptedException {
        webViewInput.click();
        Thread.sleep(KEYBOARD_ANIMATION_DELAY);
        webViewInput.sendKeys(url + "\n");
        Thread.sleep(WEBSITE_LOAD_TIME);
    }

    /**
     *
     * @return webview content description
     */
    public boolean getWebDescription(){
        tapScreenCenter();

        try {
            return loadedWebView.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
