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

package Tests.Inputs;

import Pages.Inputs.EditTextPage;
import Tests.AbstractBaseTests.InputTests;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Tests for a text input
 */
public class EditText extends InputTests {
    private final String TEXT_TO_INPUT = "Something";

    /**
     * A edit text page
     */
    private EditTextPage editTextPage;

    /**
     * Sets the page view index so it can be navigated to
     *
     * @return the pageview index
     */
    @Override
    public int pageIndex() {
        return 0;
    }

    /**
     * Creates the edit text page
     */
    @BeforeTest
    @Override
    public void setUpPage() {
        editTextPage = new EditTextPage(driver);
    }

    /**
     * Tests input to the edit text box and then verifies if the text is there
     */
    @Test
    public void testTextBox(){
        editTextPage.enterText(TEXT_TO_INPUT);
        Assert.assertTrue(editTextPage.getTextBoxText().contains(TEXT_TO_INPUT));
    }
}
