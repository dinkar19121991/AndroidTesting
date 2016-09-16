package com.dinkark.androidtesting.unit.basic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.Assert.assertEquals;
import static org.junit.runners.Parameterized.Parameter;
import static org.junit.runners.Parameterized.Parameters;
/**
 * Created by dinkark on 15/09/16.
 */
@RunWith(Parameterized.class)
public class CalulatorParameterizedTest {
    @Parameter(value = 0)
    public int val1;
    @Parameter(value = 1)
    public int val2;
    // creates the test data
    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] { { 3 , 2 }, { 5, -3 }, { -121, 4 } ,{-2,-9}};
        return Arrays.asList(data);
    }
    @Test
    public void testAddition() {
        Calculator calc = new Calculator();
        assertEquals("Result", val1 + val2, calc.addition(val1, val2));
    }
    @Test
    public void testSubtraction() {
        Calculator calc = new Calculator();
        assertEquals("Result", val1 - val2, calc.subtraction(val1, val2));
    }
}
