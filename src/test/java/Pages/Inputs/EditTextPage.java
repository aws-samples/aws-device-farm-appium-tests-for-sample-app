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
    @AndroidFindBy(id = "input_edit_text")
    private MobileElement textBox;

    public EditTextPage(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Input text
     *
     * @param text to input
     */
    public void enterText(String text){
        textBox.sendKeys(text);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @return the contents of the text box
     */
    public String getTextBoxText(){
        return textBox.getText();
    }
}
