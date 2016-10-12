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

import Pages.Inputs.CheckBoxPage;
import Tests.AbstractBaseTests.InputTests;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Tests the checkbox
 */
public class CheckboxTest extends InputTests {
    private static final String CHECKED_VALUE = "Checked";

    /**
     * Checkbox page
     */
    private CheckBoxPage checkBoxPage;

    /**
     * Sets the page view index so it can be navigated to
     *
     * @return the pageview index
     */
    @Override
    public int pageIndex() {
        return 1;
    }

    /**
     * Creates the checkbox page
     */
    @BeforeTest
    @Override
    public void setUpPage() {
        checkBoxPage = new CheckBoxPage(driver);
    }

    /**
     * Verifies whether checked message appears on the screen once
     * the checkbox is checked.
     */
    @Test
    public void testCheckBox() {
        checkBoxPage.touchCheckBox();
        Assert.assertEquals(checkBoxPage.getCheckBoxDisplay(), CHECKED_VALUE);
    }
}
