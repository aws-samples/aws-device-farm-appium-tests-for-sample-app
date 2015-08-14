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
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.Dimension;

public class TabViewPage extends BasePage{
    private final double START_OFFSET = 0.9;
    private final double END_OFFSET = 0.05;
    private final int SWIPE_DURATION = 1000;

    @AndroidFindBy(id = "container_body")
    private MobileElement tabViewContainer;


    public TabViewPage(AppiumDriver driver) {
        super(driver);
    }

    public void turnPageLeft(){
        Dimension size = driver.manage().window().getSize();
        int startx = (int) (size.width * START_OFFSET);
        int endx = (int) (size.width * END_OFFSET);
        int starty = size.height / 2;
        driver.swipe(startx, starty, endx, starty, SWIPE_DURATION);
    }
}
