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
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

public class TabViewPage extends BasePage{
    private static final double START_OFFSET = 0.95;
    private static final double END_OFFSET = 0.05;
    private static final int SWIPE_DURATION = 1000;
    private static final int ALERT_POP_UP_DELAY = 1000;
    private static final String BAD_VIDEO_TEXT = "Can't play this video.";
    private static final String OK_BUTTON_NAME = "OK";

    @AndroidFindBy(id = "container_body")
    private MobileElement tabViewContainer;


    public TabViewPage(AppiumDriver driver) {
        super(driver);
    }

    public void turnPageLeft() throws InterruptedException {
        Dimension size = driver.manage().window().getSize();
        int startX = (int) (size.width * START_OFFSET);
        int endX = (int) (size.width * END_OFFSET);
        int startY = size.height / 4;
        driver.swipe(startX, startY, endX, startY, SWIPE_DURATION);

        acceptBadVideoAlert();
    }

    private void acceptBadVideoAlert() throws InterruptedException {
        Thread.sleep(ALERT_POP_UP_DELAY);

        if (!driver.findElementsByName(BAD_VIDEO_TEXT).isEmpty()) {
            WebElement okButton = driver.findElementByName(OK_BUTTON_NAME);
            okButton.click();
        }
    }
}
