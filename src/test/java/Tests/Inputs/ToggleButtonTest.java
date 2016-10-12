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

import Pages.Inputs.ToggleButtonPage;
import Tests.AbstractBaseTests.InputTests;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Tests for a toggle button
 */
public class ToggleButtonTest extends InputTests {
    private static final String TOGGLE_ACTIVATED_TEXT = "ON";
    private static final String TOGGLE_DEACTIVATED_TEXT = "OFF";

    private ToggleButtonPage toggleButtonPage;

    /**
     * Sets the page view index so it can be navigated to
     *
     * @return the pageview index
     */
    @Override
    public int pageIndex() {
        return 3;
    }

    /**
     * Creates the toggle button page
     */
    @BeforeTest
    @Override
    public void setUpPage() {
        toggleButtonPage = new ToggleButtonPage(driver);
    }

    /**
     * Tests toggle switch by touching the switch, then verifying that the
     * activated element appears
     */
    @Test
    public void testToggle() {
        toggleButtonPage.toggleSwitch();
        Assert.assertEquals(toggleButtonPage.getToggleDisplayStatus(), TOGGLE_ACTIVATED_TEXT);
        toggleButtonPage.toggleSwitch();
        Assert.assertEquals(toggleButtonPage.getToggleDisplayStatus(), TOGGLE_DEACTIVATED_TEXT);
    }
}
