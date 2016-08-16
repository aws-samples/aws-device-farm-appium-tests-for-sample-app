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
 * A page for a image gallery (in a grid view)
 */
public class ImageGalleryPage extends BasePage {
    /**
     * the image gallery grid view
     */
    @AndroidFindBy(className = "android.widget.GridView")
    private MobileElement imageGalley;

    public ImageGalleryPage(AppiumDriver driver) {
        super(driver);
    }

    /**
     *
     * @return if the grid view is displayed
     */
    public boolean imageGalleryIsDisplayed() {
        return imageGalley.isDisplayed();
    }
}
