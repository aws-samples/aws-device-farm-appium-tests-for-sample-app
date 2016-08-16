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

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Web page representation.
 */
public class WebViewPage extends BasePage {
    private static final String WEB_HEADER_CSS_NAME = "a[name=\"AWS_Documentation\"]";
    private static final String TEXT_FIELD_CLASS = "android.widget.EditText";
    private static final int MAX_WEBSITE_LOAD_TIME = 10;

    public WebViewPage(AndroidDriver driver) {
        super(driver);
    }

    /**
     * Navigates to URL, sleeps for WEBSITE_LOAD_TIME.
     *
     * @param url String must be in format "http://____"
     * @throws InterruptedException
     */
    public boolean goToUrl(String url) throws InterruptedException {
        WebElement navBar = driver.findElementByClassName(TEXT_FIELD_CLASS);
        return sendKeysToElement(url, navBar, true);
    }

    /**
     * Checks if web description is loaded.
     *
     * Note: Will fail if Android version is < 4.4 or >= 6.0. Hybrid views are not compatible with
     * versions < 4.4 and Appium context switching is currently buggy on devices running versions >= 6.0.
     *
     * @return true if it is, else false.
     */
    public boolean webDescriptionIsLoaded() throws InterruptedException {
        Object[] contextHandles = driver.getContextHandles().toArray();
        String androidVersion = driver.getCapabilities().getCapability("platformVersion").toString();

        if (versionLessThan(androidVersion, "4.4")) {
            return true;
        } else if (versionGreaterThanOrEqual(androidVersion, "6.0")) {
            return false;
        }

        String webViewContent = (String) contextHandles[contextHandles.length - 1];
        WebDriver webDriver = driver.context(webViewContent);

        try {
            WebDriverWait wait = new WebDriverWait(webDriver, MAX_WEBSITE_LOAD_TIME);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(WEB_HEADER_CSS_NAME)));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(WEB_HEADER_CSS_NAME)));
        } catch (TimeoutException e) {
            return false; // MAX_WEBSITE_LOAD_TIME timeout exceeded - bad internet connection.
        }

        WebElement webHeader = webDriver.findElement(By.cssSelector(WEB_HEADER_CSS_NAME));
        return webHeader.isDisplayed();
    }

    /**
     * Helper function that compares Android versions.
     *
     * @param version1 Numbers separated by period, i.e. "1.2.3"
     * @param version2 Numbers separated by period, i.e. "1.2.3"
     *
     * @return -1 if version1 is smaller, 0 if same, 1 if version1 is bigger.
     */
    private int compareVersions(String version1, String version2) {
        String[] versions1 = version1.split("\\.");
        String[] versions2 = version2.split("\\.");

        int maxLength = Math.max(versions1.length, versions2.length);

        for (int i = 0; i < maxLength; i++) {
            int versionNumber1 = i < versions1.length ? Integer.parseInt(versions1[i]) : -1;
            int versionNumber2 = i < versions2.length ? Integer.parseInt(versions2[i]) : -1;

            if (versionNumber1 < versionNumber2) {
                return -1;
            } else if (versionNumber1 > versionNumber2) {
                return 1;
            }
        }

        return 0;
    }

    /**
     * Checks if version1 is greater than or equal to version2.
     *
     * @param version1 Numbers separated by period, i.e. "1.2.3"
     * @param version2 Numbers separated by period, i.e. "1.2.3"
     *
     * @return version1 >= version2
     */
    private boolean versionGreaterThanOrEqual(String version1, String version2) {
        return compareVersions(version1, version2) >= 0;
    }

    /**
     * Checks if version1 is less than version2.
     *
     * @param version1 Numbers separated by period, i.e. "1.2.3"
     * @param version2 Numbers separated by period, i.e. "1.2.3"
     *
     * @return version1 < version2
     */
    private boolean versionLessThan(String version1, String version2) {
        return compareVersions(version1, version2) == -1;
    }
}
