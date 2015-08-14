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

import Pages.LoginPage;
import Tests.AbstractBaseTests.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Tests for a login page
 */
public class LoginTest extends TestBase {
    private final String LOGIN_SUCCESS_MESSAGE = "You are logged on as admin";
    private final String LOGIN_FAIL_MESSAGE = "You gave me the wrong username and password";
    private final String CORRECT_USER_NAME = "admin";
    private final String CORRECT_PASSWORD = "password";
    private final String FAIL_USER_NAME = "Wrong User";
    private final String FAIL_PASSWORD = "12345";

    private LoginPage loginPage;

    @Override
    public String getName() {
        return "Login Page";
    }

    /**
     * Creates a login
     */
    @BeforeTest
    @Override
    public void setUpPage() {
        loginPage = new LoginPage(driver);
    }

    /**
     * Tests logging in with valid credentials by verifying if the login message is correct
     */
    @Test
    public void loginSuccessFully(){
        loginPage.loginIn(CORRECT_USER_NAME, CORRECT_PASSWORD);
        Assert.assertEquals(loginPage.getMessage(), LOGIN_SUCCESS_MESSAGE);
    }

    /**
     * Tests logging in with invalid credentials by verifying if the error message is correct
     */
    @Test
    public void loginFail() {
        loginPage.loginIn(FAIL_USER_NAME, FAIL_PASSWORD);
        Assert.assertEquals(loginPage.getMessage(), LOGIN_FAIL_MESSAGE);
    }

    /**
     * After each test method, logout or try again
     */
    @AfterMethod
    public void logOut(){
        loginPage.pressAltButton();
        Assert.assertTrue(loginPage.checkIfBackAtLogin());
    }
}
