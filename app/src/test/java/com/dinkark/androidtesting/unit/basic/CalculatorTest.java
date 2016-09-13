package com.dinkark.androidtesting.unit.basic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;

/**
 * Created by dinkark on 13/09/16.
 */
@RunWith(JUnit4.class)
public class CalculatorTest {
    @Test
    public void additionTrue(){
        assertEquals(5,Calculator.addition(2,3));
        assertEquals(-5,Calculator.addition(-2,-3));
        assertEquals(-5,Calculator.addition(2,-7));
    }
    @Test
    public void additionFalse(){
        assertFalse(6==Calculator.addition(2,3));
        assertFalse(-1==Calculator.addition(-2,-3));
        assertFalse(-9==Calculator.addition(2,-7));
    }
    @Test
    public void subtractionTrue(){
        assertEquals(-1,Calculator.subtraction(2,3));
        assertEquals(1,Calculator.subtraction(-2,-3));
        assertEquals(9,Calculator.subtraction(2,-7));
    }
    @Test
    public void subtractionFalse(){
        assertFalse(1==Calculator.subtraction(2,3));
        assertFalse(-5==Calculator.subtraction(-2,-3));
        assertFalse(-5==Calculator.subtraction(2,-7));
    }
}
