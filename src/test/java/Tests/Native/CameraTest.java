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

import Pages.Native.CameraPage;
import Tests.AbstractBaseTests.NativeTests;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Tests to test a camera preview
 */
public class CameraTest extends NativeTests {
    private static final String CAMERA_ON_STATUS = "Camera Preview Streaming";

    private CameraPage cameraPage;

    /**
     * Sets the page view index so it can be navigated to
     *
     * @return the pageview index
     */
    @Override
    public int pageIndex() {
        return 3;
    }

    @BeforeTest
    @Override
    public void setUpPage() {
        cameraPage = new CameraPage(driver);
    }

    /**
     * Tests a camera preview by checking if the preview's content description
     * indicates that the camera is on and streaming. Fails on devices with no camera support.
     */
    @Test
    public void testCameraStatus() {
        Assert.assertEquals(cameraPage.getCameraStatus(), CAMERA_ON_STATUS);
    }
}
