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
    /**
     * The default (Space Needle) location within Device Farm
     */
    private final String LATITUDE = "47.6204";
    private final String LONGITUDE = "-122.3491";

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
     * Tests if the Longitude is equal to the default value
     */
    @Test
    public void testLongitude(){
        Assert.assertEquals(fixturesPage.getLongitude(), LONGITUDE);
    }

    /**
     * Tests if the Latitude is equal to the default value
     */
    @Test
    public void testLatitude(){
        Assert.assertEquals(fixturesPage.getLatitude(), LATITUDE);
    }

    /**
     * Tests to see if wifi is on
     */
    @Test
    public void testWifiOn(){
        Assert.assertTrue(Boolean.parseBoolean(fixturesPage.getWifi()));
    }

    /**
     * Tests to see if the bluetooth is on
     */
    @Test
    public void testBluetoothOn(){
        Assert.assertTrue(Boolean.parseBoolean(fixturesPage.getBluetooth()));
    }

    /**
     * Tests to see if the GPS is on
     */
    @Test
    public void testGPSOn(){
        Assert.assertTrue(Boolean.parseBoolean(fixturesPage.getGps()));
    }

    /**
     * Tests to see if NFC is on
     */
    @Test
    public void testNFCOn(){
        Assert.assertTrue(Boolean.parseBoolean(fixturesPage.getNfc()));
    }
}
