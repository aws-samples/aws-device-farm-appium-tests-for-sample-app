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

import Pages.Inputs.GesturesPage;
import Tests.AbstractBaseTests.InputTests;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Tests for Gestures
 */
public class GesturesTest extends InputTests {
    private static final String FLING_COMMAND = "Fling";
    private static final String LONG_COMMAND = "Long Press";
    private static final String SINGLE_TAP_COMMAND = "Single tap confirmed";

    private GesturesPage gesturesPage;

    /**
     * Sets the page view index so it can be navigated to
     *
     * @return the pageview index
     */
    @Override
    public int pageIndex() {
        return 9;
    }

    /**
     * Creates a Gestures page
     */
    @BeforeTest
    @Override
    public void setUpPage() {
        gesturesPage = new GesturesPage(driver);
    }

    /**
     * Performs a fling and verifies if the action was registered
     * by checking if its command name is shown.
     */
    @Test
    public void testFling() {
        gesturesPage.flingGesture();
        Assert.assertEquals(gesturesPage.getLastAction(), FLING_COMMAND);
    }

    /**
     * Performs a long press and verifies if the action was registered
     * by checking if its command name is shown.
     */
    @Test
    public void testLongPress() {
        gesturesPage.longPress();
        Assert.assertEquals(gesturesPage.getLastAction(), LONG_COMMAND);
    }

    /**
     * Performs a single press and verifies if the action was registered
     * by checking if its command name is shown.
     */
    @Test
    public void testSinglePress() {
        gesturesPage.singlePress();
        Assert.assertEquals(gesturesPage.getLastAction(), SINGLE_TAP_COMMAND);
    }
}
