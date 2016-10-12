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
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

/**
 * A page for a toggle button control
 */
public class ToggleButtonPage extends BasePage {
    /**
     * The toggle switch
     */
    @AndroidFindBy(className = "android.widget.Switch")
    private MobileElement toggleSwitch;

    public ToggleButtonPage(AppiumDriver driver) {
        super(driver);
    }

    /**
     * toggle the toggle button
     */
    public void toggleSwitch() {
        toggleSwitch.click();
    }

    /**
     *
     * @return the display
     */
    public String getToggleDisplayStatus() {
        List frameLayouts = driver.findElementsByClassName("android.widget.FrameLayout");
        MobileElement toggleDisplay = (MobileElement) frameLayouts.get(frameLayouts.size() - 1);
        return toggleDisplay.getAttribute("name");
    }
}
