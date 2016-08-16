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

package Tests.Inputs;

import Pages.Inputs.RadioButtonPage;
import Tests.AbstractBaseTests.InputTests;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RadioButtonTest extends InputTests {
    private RadioButtonPage radioButtonPage;

    /**
     * Sets the page view index so it can be navigated to
     *
     * @return the pageview index
     */
    @Override
    public int pageIndex() {
        return 2;
    }

    @BeforeTest
    @Override
    public void setUpPage() {
        radioButtonPage = new RadioButtonPage(driver);
    }

    @Test
    public void testFirstRadio() {
        radioButtonPage.clickRadioButton1();
        Assert.assertEquals(radioButtonPage.getRadioText(), "Amazon");
    }

    @Test
    public void testSecondRadio() {
        radioButtonPage.clickRadioButton2();
        Assert.assertEquals(radioButtonPage.getRadioText(), "Web");
    }

    @Test
    public void testThirdRadio() {
        radioButtonPage.clickRadioButton3();
        Assert.assertEquals(radioButtonPage.getRadioText(), "Services");
    }
}
