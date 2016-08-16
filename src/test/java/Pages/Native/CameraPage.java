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

package Pages.Native;

import Pages.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * A page for a camera preview
 */
public class CameraPage extends BasePage {
    /**
     * The camera preview
     */
    @AndroidFindBy(name = "Camera Preview Streaming")
    private MobileElement cameraPreview;

    public CameraPage(AppiumDriver driver) {
        super(driver);
    }

    /**
     *
     * @return the content description of the camera preview
     */
    public String getCameraStatus(){
        return cameraPreview.getAttribute("name");
    }
}
