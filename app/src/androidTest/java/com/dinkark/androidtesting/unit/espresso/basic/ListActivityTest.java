package com.dinkark.androidtesting.unit.espresso.basic;

import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.dinkark.androidtesting.R;
import com.dinkark.androidtesting.espresso.basic.ListActivity;
import com.dinkark.androidtesting.espresso.basic.MainActivity;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
public class ListActivityTest {
  @Rule
  public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

  @Test
  public void clickItem() throws InterruptedException {
    //launch Image Activity
    onView(withId(R.id.launchListActivity)).perform(click());
    // Check that the ImageView doesn't have a drawable applied.
    onView(withId(R.id.text))
        .check(matches(not(isDisplayed())));
// load data and scroll to item with value 27 and click it
    onData(withValue(27))
        .inAdapterView(withId(R.id.list))
        .perform(click());
    //sleep
    Thread.sleep(500);

// check whether 27 is displayed at bottom or not
    onView(withId(R.id.text))
            .check(matches(withText("27")))
            .check(matches(isDisplayed()));
// load data and scroll to item at position 19  and click it
    onData(anything()).atPosition(19)
            .inAdapterView(withId(R.id.list))
            .perform(click());
    //sleep
    Thread.sleep(500);

// check whether 19 is displayed at bottom or not
    onView(withId(R.id.text))
        .check(matches(withText("19")))
        .check(matches(isDisplayed()));

    // load data and scroll to item at position 19  and click it
    onData(anything()).atPosition(19)
            .inAdapterView(withId(R.id.list))
            .perform(click());
    //sleep
    Thread.sleep(500);

// check whether 19 is displayed at bottom or not
    onView(withId(R.id.text))
            .check(matches(withText("19")))
            .check(matches(isDisplayed()));
  }

  public static Matcher<Object> withValue(final int value) {
    return new BoundedMatcher<Object, ListActivity.Item>(ListActivity.Item.class) {
      @Override
      public void describeTo(Description description) {
        description.appendText("has value " + value);
      }
      @Override
      public boolean matchesSafely(ListActivity.Item item) {
        return item.toString().equals(String.valueOf(value));
      }
    };
  }
}