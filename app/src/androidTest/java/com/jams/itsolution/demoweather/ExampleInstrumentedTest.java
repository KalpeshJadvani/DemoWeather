package com.jams.itsolution.demoweather;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.view.View;


import com.jams.itsolution.demoweather.presenter.MainPresenter;
import com.jams.itsolution.demoweather.view.MainActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(MainActivity.class);

    private Activity activity = null;

    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(MainPresenter.class.getName(),null,false);

    @Before
    public void setup() {

        activity = mActivityRule.getActivity();

    }

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.jams.itsolution.demoweather", appContext.getPackageName());

        View testNotNull = activity.findViewById(R.id.loading_bar);

        assertNotNull(testNotNull);


        Espresso.onView(withId(R.id.loading_bar)).check(matches(isDisplayed()));

        //assertThat(testNotNull, isDisplayed());

        getInstrumentation().waitForMonitorWithTimeout(monitor,5000);

        RecyclerView recyclerView = activity.findViewById(R.id.temperature_list);

        assertNotNull(recyclerView);

        assertEquals(7,recyclerView.getAdapter().getItemCount());

    }


    @After
    public void tearDown(){

        getInstrumentation().removeMonitor(monitor);
        mActivityRule = null;

    }

}
