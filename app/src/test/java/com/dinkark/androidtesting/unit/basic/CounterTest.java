package com.dinkark.androidtesting.unit.basic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static junit.framework.Assert.assertEquals;

/**
 * Created by dinkark on 16/09/16.
 */
@RunWith(JUnit4.class)
public class CounterTest {
    static Counter classCounterObj;
    Counter instanceCounterObj1;
    Counter instanceCounterObj2;

    @BeforeClass
    public static void setup() {
        classCounterObj = new Counter();
    }

    @Before
    public void testSetup() {
        instanceCounterObj1 = new Counter();
        instanceCounterObj2 = new Counter();
    }

    @Test
    public void testClassCounter(){
        classCounterObj.increaseClassCounter();
        instanceCounterObj1.increaseClassCounter();
        instanceCounterObj2.increaseClassCounter();
        instanceCounterObj2.increaseClassCounter();
        assertEquals(4,Counter.classCount);
      }
    @Test
    public void testInstanceCounter(){
        classCounterObj.increaseInstanceCounter();
        instanceCounterObj1.increaseInstanceCounter();
        instanceCounterObj2.increaseInstanceCounter();
        instanceCounterObj2.increaseInstanceCounter();
        assertEquals(1,instanceCounterObj1.instanceCount);
        assertEquals(2,instanceCounterObj2.instanceCount);
    }
    @Test
    public void testInstanceCounter2(){
        classCounterObj.increaseInstanceCounter();
        instanceCounterObj1.increaseInstanceCounter();
        instanceCounterObj1.increaseInstanceCounter();
        instanceCounterObj2.increaseInstanceCounter();
        assertEquals(2,instanceCounterObj1.instanceCount);
        assertEquals(1,instanceCounterObj2.instanceCount);
    }
    @Test
    public void testInstanceCounter3(){
        classCounterObj.increaseInstanceCounter();
        instanceCounterObj1.increaseInstanceCounter();
        instanceCounterObj2.increaseInstanceCounter();
        assertEquals(1,instanceCounterObj1.instanceCount);
        assertEquals(1,instanceCounterObj2.instanceCount);
    }
    @After
    public void testDestroy() {
        instanceCounterObj1 = null;
        instanceCounterObj2 = null;
    }

    @AfterClass
    public static void destroy() {
        assertEquals(3,classCounterObj.instanceCount);
        classCounterObj = null;
    }
}
