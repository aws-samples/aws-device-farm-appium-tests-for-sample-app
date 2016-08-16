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
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * A Page representing a local web view
 */
public class LocalWebViewPage extends BasePage {
    /**
     * All of the text inputs
     */
    @AndroidFindAll(
            @AndroidFindBy(className = "android.widget.EditText")
    )
    private List<WebElement> inputs;

    /**
     * All of the views
     */
    @AndroidFindAll(
            @AndroidFindBy(className = "android.view.View")
    )
    private List<WebElement> output;


    public LocalWebViewPage(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Enter the a name into the text fields
     *
     * @param first first name
     * @param last last name
     *
     * @return true if names entered in correctly, else false.
     */
    public boolean enterName(String first, String last) throws InterruptedException {
        boolean firstNameStatus = sendKeysToElement(first, inputs.get(0), false);
        boolean lastNameStatus = sendKeysToElement(last, inputs.get(1), false);

        return firstNameStatus && lastNameStatus;
    }

    /**
     *
     * @return full name text
     */
    public String getFullName() {
        return output.get(output.size()-1).getAttribute("content-desc").split("Hello!")[1];
    }
}
