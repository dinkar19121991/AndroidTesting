package com.dinkark.androidtesting.unit.instrumented;

import android.app.Instrumentation;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.AndroidTestCase;
import android.test.InstrumentationTestCase;

import com.dinkark.androidtesting.espresso.basic.MainActivity;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;

/**
 * Created by dinkark on 16/09/16.
 */
@RunWith(AndroidJUnit4.class)
public class SharedPrefTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);
    SharedPreferences preferences;
    static SharedPreferences.Editor editor;
    static final String STRING_KEY = "Name";
    static final String BOOLEAN_KEY = "flag";
    static final String INT_KEY = "value";
    static final String STRING_VALUE = "Dinkar";
    static final String STRING_WRONG_VALUE = "Wrong";
    static final boolean BOOLEAN_FLAG = true;
    static final int INT_VALUE = 25;

    @Before
    public void setup() {
        preferences = mActivityRule.getActivity().getSharedPreferences("Test", Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    @Test
    public void testSharedprefString() {
        //assertEquals(STRING_VALUE, preferences.getString(STRING_KEY, STRING_WRONG_VALUE));
        editor.putString(STRING_KEY, STRING_VALUE).commit();
        assertEquals(STRING_VALUE, preferences.getString(STRING_KEY, STRING_WRONG_VALUE));
    }

    @Test
    public void testSharedprefBoolean() {
        editor.putBoolean(BOOLEAN_KEY, BOOLEAN_FLAG).commit();
        assertEquals(BOOLEAN_FLAG, preferences.getBoolean(BOOLEAN_KEY, false));
    }

    @Test
    public void testSharedprefInt() {
        editor.putInt(INT_KEY, INT_VALUE).commit();
        assertEquals(INT_VALUE, preferences.getInt(INT_KEY, 10));
    }

    @AfterClass
    public static void cleanup() {
    editor.clear().commit();
    }

}
