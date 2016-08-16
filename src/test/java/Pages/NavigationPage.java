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

package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

/**
 * A page for navigation drawer
 */
public class NavigationPage extends BasePage{

    private final int TRIES = 5;

    /**
     * Get the toggle button
     */
    @AndroidFindBy(name = "ReferenceApp")
    private WebElement toggle;

    public NavigationPage(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Go to a specific category within the navigation drawer
     *
     * @param categoryName category
     */
    public void gotoCategory(String categoryName) {
        int counter = 0;
        toggle.click();
        try {
            Thread.sleep(WaitConfig.DRAWER_ANIMATION_WAIT);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement categoryElement = null;

        while (categoryElement == null) {
            try {
                counter++;
                if (counter == TRIES)
                    return;
                categoryElement = driver.findElementByName(categoryName);
            } catch (NoSuchElementException e) {
                driver.scrollTo(categoryName);
            }
        }

        categoryElement.click();
    }
}
