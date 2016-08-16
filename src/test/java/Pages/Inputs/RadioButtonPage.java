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

public class RadioButtonPage extends BasePage {

    @AndroidFindBy(name = "Radio Button 1")
    private MobileElement radioButton1;

    @AndroidFindBy(name = "Radio Button 2")
    private MobileElement radioButton2;

    @AndroidFindBy(name = "Radio Button 3")
    private MobileElement radioButton3;

    @AndroidFindBy(name = "Radio Button Display")
    private MobileElement radioText;

    public RadioButtonPage(AppiumDriver driver) {
        super(driver);
    }

    public String getRadioText() {
        return radioText.getText();
    }

    public void clickRadioButton1() {
        radioButton1.click();
    }

    public void clickRadioButton2() {
        radioButton2.click();
    }

    public void clickRadioButton3() {
        radioButton3.click();
    }
}
