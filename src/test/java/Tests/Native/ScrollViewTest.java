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

import Pages.Native.ContentScrollingPage;
import Tests.AbstractBaseTests.NativeTests;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Tests for the scroll view
 */
public class ScrollViewTest extends NativeTests {
    private ContentScrollingPage contentScrollingPage;

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
     * Sets up the scrollview page
     */
    @BeforeTest
    @Override
    public void setUpPage() {
        contentScrollingPage = new ContentScrollingPage(driver);
    }

    /**
     * Tests by scrolling down and checking if the scrollview is still displayed
     */
    @Test
    public void testScroll() {
        contentScrollingPage.scrollDown();
        Assert.assertTrue(contentScrollingPage.scrollViewDisplayed());
    }
}
