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
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

/**
 * A page representing a crash
 *
 */
public class CrashPage extends BasePage {
    /**
     * The crash button
     */
    @AndroidFindBy(name = "Crash Button")
    private WebElement crashButton;

    /**
     * The crash message
     */
    @AndroidFindBy(name = "Unfortunately, ReferenceApp has stopped.")
    private WebElement crashMessage;

    public CrashPage(AppiumDriver driver) {
        super(driver);
    }

    /**
     * pressed a crash button
     */
    public void clickCrashButton() {
        crashButton.click();
    }

    /**
     *
     * @return the crash message
     */
    public String getCrashMessage(){
        return crashMessage.getText();
    }
}
