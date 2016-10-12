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

/**
 * A page for alerts
 */
public class AlertPage extends BasePage {
    /**
     * The alert button
     */
    @AndroidFindBy(name = "ALERT")
    private MobileElement alertButton;

    /**
     * The toast button
     */
    @AndroidFindBy(name = "TOAST")
    private MobileElement toastButton;

    public AlertPage(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Toast isn't directly supported by Appium. The recommended way is to
     * take a screen shot and use a OCR program to read the toast content
     */
    public void clickToastButton() {
        toastButton.click();
    }

    /**
     * clicks the alert button
     */
    public void clickAlertsButton() {
        alertButton.click();
    }

    /**
     *
     * @return the message within the alert
     */
    public String getAlertText() {
        MobileElement alertMessage = (MobileElement) driver.findElementsByClassName("android.widget.TextView").get(1);
        return alertMessage.getText();
    }

    /**
     * accepts the alert
     */
    public void acceptAlertMessage() {
        MobileElement alertOkButton = (MobileElement) driver.findElementsByClassName("android.widget.Button").get(0);
        alertOkButton.click();
    }
}