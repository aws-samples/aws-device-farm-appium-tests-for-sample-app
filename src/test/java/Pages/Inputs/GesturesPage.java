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

package Pages.Inputs;

import Pages.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * A page for gestures
 */
public class GesturesPage extends BasePage {
    /**
     * A page that performs specific gestures
     */
    @AndroidFindBy(name = "Gesture Action Pad")
    private MobileElement gestureBox;

    /**
     * The displays which lists the performed gestures
     */
    @AndroidFindBy(name = "Gestures Display")
    private MobileElement display;


    public GesturesPage(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Performs a single press
     */
    public void singlePress() {
        gestureBox.click();
    }

    /**
     * Performs a long press
     */
    public void longPress() {
        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(gestureBox).perform();
    }

    /**
     * performs a fling gesture
     */
    public void flingGesture() {
        try {
            gestureBox.swipe(SwipeElementDirection.UP, 10, 10, 100);
        } catch (Exception e) {} // Catch "The swipe did not complete successfully" error
    }

    /**
     *
     * @return the text of the last action performed
     */
    public String getLastAction(){
        String[] entries = display.getText().split("\n");
        return entries[entries.length - 1];
    }
}
