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

package Tests.Native;

import Pages.Native.OutOfViewPage;
import Tests.AbstractBaseTests.NativeTests;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OutOfViewTest extends NativeTests {
    private OutOfViewPage outOfViewPage;

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
     * Sets up the out of view page
     */
    @BeforeTest
    @Override
    public void setUpPage() {
        outOfViewPage = new OutOfViewPage(driver);
    }

    /**
     * tests the scrollview by scrolling down and checking if the hidden text is
     * displayed.
     */
    @Test
    public void scrollOutOfView() {
        outOfViewPage.scrollDownToHiddenText();
        Assert.assertTrue(outOfViewPage.isHiddenTextDisplayed());
    }


}
