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

package Tests;

import Pages.HomePage;
import Tests.AbstractBaseTests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Tests for homepage
 */
public class HomePageTest extends TestBase {
    private static final String HOMEPAGE_HEADLINE = "AWS Device Farm Sample App for Android";
    private static final String HOMEPAGE_SUBHEADER = "version 1";

    private HomePage homePageTest;

    /**
     * Sets up homepage
     */
    @BeforeTest
    @Override
    public void setUpPage() {
        homePageTest = new HomePage(driver);
    }

    /**
     * Asserts the homepage headline
     */
    @Test
    public void testHomePageHeadline() {
        Assert.assertEquals(homePageTest.getHeadlineValue(), HOMEPAGE_HEADLINE);
    }

    /**
     * Asserts the homepage subheader
     */
    @Test
    public void testHomePageSubheader() {
        Assert.assertEquals(homePageTest.getSubheaderValue(), HOMEPAGE_SUBHEADER);
    }

    @Override
    public String getName() {
        return "Home";
    }
}
