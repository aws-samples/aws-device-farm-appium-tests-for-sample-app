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

package Tests.Inputs;


import Pages.Inputs.SpinnerPage;
import Tests.AbstractBaseTests.InputTests;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Tests for the spinner control
 */
public class SpinnerTest extends InputTests {
    private static final String SPINNER_BASE_STRING = "Selected: %s";

    private SpinnerPage spinnerPage;

    /**
     * Sets the page view index so it can be navigated to
     *
     * @return the pageview index
     */
    @Override
    public int pageIndex() {
        return 4;
    }

    /**
     * Creates the spinner page
     */
    @BeforeTest
    @Override
    public void setUpPage() {
        spinnerPage = new SpinnerPage(driver);
    }

    /**
     * Tests a spinner control by selecting the spinner at a specific index then verifying if the selected
     * text appears in the text view
     */
    @Test
    public void checkIndex() {
        spinnerPage.selectSpinnerAtIndex(3);
        Assert.assertEquals(spinnerPage.getDisplayText(), String.format(SPINNER_BASE_STRING, spinnerPage.getSelectedEntry()));
    }
}
