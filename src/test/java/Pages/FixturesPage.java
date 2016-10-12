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

import java.util.List;

/**
 * A page representing the fixtures
 */
public class FixturesPage extends BasePage {

    public FixturesPage(AppiumDriver driver) {
        super(driver);
    }

    /**
     *
     * @return wifi status
     */
    public String getWifi() {
        return getStatus("Wifi:");
    }

    /**
     *
     * @return bluetooth status
     */
    public String getBluetooth() {
        return getStatus("Bluetooth:");
    }

    /**
     *
     * @return gps status
     */
    public String getGps() {
        return getStatus("GPS:");
    }

    /**
     *
     * @return nfc status
     */
    public String getNfc() {
        return getStatus("NFC:");
    }

    /**
     * Helper function to retrieve the status of inputted radio name.
     *
     * @param radioName should be followed by a colon, for example: "NFC:"
     * @return status of radio signal as a String
     */
    private String getStatus(String radioName) {
        driver.scrollTo(radioName);
        List textViews = driver.findElementsByClassName("android.widget.TextView");

        int idx;

        // Retrieve index of desired radio text view
        for (idx = textViews.size() - 1; idx >= 0; idx--) {
            if (((MobileElement) textViews.get(idx)).getText().equals(radioName)) {
                break;
            }
        }

        // Desired radio status comes immediately after its name. For example: NFC: true
        return ((MobileElement) textViews.get(idx + 1)).getText();
    }
}
