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

/**
 * A page for a text input
 */
public class EditTextPage extends BasePage {
    /**
     * The text input
     */
    @AndroidFindBy(name = "Text Input Control")
    private MobileElement textBox;

    public EditTextPage(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Input text
     *
     * @param text to input
     *
     * @return true, if text properly entered, else false.
     */
    public boolean enterText(String text) throws InterruptedException {
        return sendKeysToElement(text, textBox, false);
    }

    /**
     *
     * @return the contents of the text box
     */
    public String getTextBoxText(){
        return textBox.getText();
    }
}
