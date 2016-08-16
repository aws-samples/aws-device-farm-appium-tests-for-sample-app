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
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * A login page
 */
public class LoginPage extends BasePage {
    private static final int KEYBOARD_ANIMATION_DELAY = 1000;

    /**
     * The login button
     */
    @AndroidFindBy(name = "Login Button")
    private MobileElement loginButton;

    /**
     * The user name input
     */
    @AndroidFindBy(name = "Username Input Field")
    private MobileElement usernameField;

    /**
     * The password input
     */
    @AndroidFindBy(name = "Password Input Field")
    private MobileElement passwordField;

    public LoginPage(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tries to login with a set of credentials
     *
     * @param username the username
     * @param password the password
     *
     * @return true if username was entered in correctly, else false.
     */
    public boolean login(String username, String password) throws InterruptedException {
        boolean usernameStatus = sendKeysToElement(username, usernameField, false);

        passwordField.click();
        Thread.sleep(KEYBOARD_ANIMATION_DELAY);
        passwordField.sendKeys(password);

        loginButton.click();

        return usernameStatus;
    }

    /**
     *
     * @return the login message
     */
    public String getMessage() {
        return driver.findElementById("Alt Message").getText();
    }

    /**
     * Checks to see if back at login page
     *
     * @return is back at login
     */
    public boolean checkIfBackAtLogin() {
        return loginButton.isDisplayed() && usernameField.isDisplayed() && passwordField.isDisplayed();
    }

    /**
     * Presses the logout/try again button
     */
    public void pressAltButton() {
        driver.findElementById("Alt Button").click();
    }
}
