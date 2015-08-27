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

/**
 * A page representing the fixtures
 */
public class FixturesPage extends BasePage {
    /**
     * wifi value
     */
    @AndroidFindBy(id = "wifi")
    private MobileElement wifi;

    /**
     * bluetooth value
     */
    @AndroidFindBy(id = "bluetooth")
    private MobileElement bluetooth;

    /**
     * gps value
     */
    @AndroidFindBy(id = "gps")
    private MobileElement gps;

    /**
     * nfc value
     */
    @AndroidFindBy(id = "nfc")
    private MobileElement nfc;

    public FixturesPage(AppiumDriver driver) {
        super(driver);
    }

    /**
     *
     * @return wifi status
     */
    public String getWifi() {
        return wifi.getText();
    }

    /**
     *
     * @return bluetooth status
     */
    public String getBluetooth() {
        return bluetooth.getText();
    }

    /**
     *
     * @return gps statsu
     */
    public String getGps() {
        return gps.getText();
    }

    /**
     *
     * @return nfc status
     */
    public String getNfc() {
        return nfc.getText();
    }
}
