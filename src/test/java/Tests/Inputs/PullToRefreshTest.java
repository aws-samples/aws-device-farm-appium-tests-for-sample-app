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

import Pages.Inputs.PullToRefreshPage;
import Tests.AbstractBaseTests.InputTests;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Tests for pull to refresh
 */
public class PullToRefreshTest extends InputTests {
    private PullToRefreshPage pullToRefreshPage;

    /**
     * Sets the page view index so it can be navigated to
     *
     * @return the pageview index
     */
    @Override
    public int pageIndex() {
        return 5;
    }

    /**
     * Creates pull to refresh page
     */
    @BeforeTest
    @Override
    public void setUpPage() {
        pullToRefreshPage = new PullToRefreshPage(driver);
    }

    /**
     * The pull to refresh displays the device's time if the working properly.
     *
     * Tests a pull to refresh control by pulling to refresh, waiting
     * then checks if a time appears.
     *
     *
     * @throws InterruptedException
     */
    @Test
    public void testPullToRefresh() throws InterruptedException {
        pullToRefreshPage.pullToRefresh();
        Thread.sleep(3000);
        Assert.assertTrue(pullToRefreshPage.getDisplayText().matches("\\d{2}:\\d{2}:\\d{2} (AM|PM)"));
    }
}
