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

import Pages.Native.ImageGalleryPage;
import Tests.AbstractBaseTests.NativeTests;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Tests for image gallery
 */
public class ImageGalleryTest extends NativeTests {
    private ImageGalleryPage imageGalleryPage;

    /**
     * Sets the page view index so it can be navigated to
     *
     * @return the pageview index
     */
    @Override
    public int pageIndex() {
        return 0;
    }

    /**
     * Sets up the image gallery page
     */
    @BeforeTest
    @Override
    public void setUpPage() {
        imageGalleryPage = new ImageGalleryPage(driver);
    }

    /**
     * Check if the image grid view is displayed
     */
    @Test
    public void checkIfImageGalleryDisplayed() {
        Assert.assertTrue(imageGalleryPage.imageGalleryIsDisplayed());
    }
}
