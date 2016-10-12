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

import Pages.FixturesPage;
import Tests.AbstractBaseTests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Tests for Device Farm fixtures
 */
public class FixturesTest extends TestBase {
    private static final String BOOLEAN_SELECTOR = "true|false";
    private FixturesPage fixturesPage;

    @Override
    public String getName() {
        return "Fixtures";
    }

    /**
     * Creates a fixture page
     */
    @BeforeTest
    @Override
    public void setUpPage() {
        fixturesPage = new FixturesPage(driver);
    }

    /**
     * Tests to see if wifi is on
     */
    @Test
    public void testWifiOn() {
        Assert.assertTrue(fixturesPage.getWifi().matches(BOOLEAN_SELECTOR));
    }

    /**
     * Tests to see if the bluetooth is on
     */
    @Test
    public void testBluetoothOn() {
        Assert.assertTrue(fixturesPage.getBluetooth().matches(BOOLEAN_SELECTOR));
    }

    /**
     * Tests to see if the GPS is on
     */
    @Test
    public void testGPSOn() {
        Assert.assertTrue(fixturesPage.getGps().matches(BOOLEAN_SELECTOR));
    }

    /**
     * Tests to see if NFC is on. Fails on devices with no NFC support.
     */
    @Test
    public void testNFCOn() {
        Assert.assertTrue(fixturesPage.getNfc().matches(BOOLEAN_SELECTOR));
    }
}
