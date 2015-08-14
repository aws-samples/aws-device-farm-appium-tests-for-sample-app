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
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.Keys;

/**
 * A page for a web view
 */
public class WebViewPage extends BasePage{
    /**
     * the web view input
     */
    @AndroidFindBy(id = "website_input")
    private MobileElement webViewInput;

    public WebViewPage(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Has to be in this format: "http://www.amazon.com"
     * @param url the web address
     */
    public void gotoUrl(String url) throws InterruptedException {
        webViewInput.sendKeys(url+"\n");
        Thread.sleep(6000);
    }

    /**
     *
     * @return webview content description
     */
    public boolean getWebDescription(String accessibilityId){
        return ! (driver.findElementsByAccessibilityId(accessibilityId).isEmpty());
    }
}
