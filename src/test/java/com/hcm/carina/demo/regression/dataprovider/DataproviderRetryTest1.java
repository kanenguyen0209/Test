/*
 * Copyright 2013-2020 QAPROSOFT (http://qaprosoft.com/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hcm.carina.demo.regression.dataprovider;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;

/**
 * Carina regression test with retries and it's registration in Zafira.
 * It just generate failure in 75% of cases and on retry should improve statistic
 *
 * @author qpsdemo
 */
public class DataproviderRetryTest1 extends AbstractTest {

    @Test(dataProvider = "DP1", dataProviderClass=DataproviderRetryTest.class)
    @MethodOwner(owner = "qpsdemo")
    public void testDataproviderRetry1(String testRailColumn, int a, int b, int c) {
        boolean isPassed = (new Random().nextInt(4) == 1) ? true : false;
        Assert.assertTrue(isPassed);

        setCases(testRailColumn.split(","));
        int actual = a * b;
        int expected = c;
        Assert.assertEquals(actual, expected, "Invalid sum result!");
    }



}
