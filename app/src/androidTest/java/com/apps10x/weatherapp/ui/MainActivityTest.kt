package com.apps10x.weatherapp.ui

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.activityScenarioRule
import com.apps10x.weatherapp.R
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    @Rule
    val activityScenarioRule = activityScenarioRule<MainActivity>()

    @Before
    fun setUp() {

    }

    @After
    fun tearDown() {
    }

    @Test
    fun testErrorLayout(){
        onView(withId(R.id.tvErrorMessage)).check(matches(withText("Something went wrong at our end!")))
        onView(withId(R.id.btnRetry)).perform(click())
    }

    @Test
    fun testProgressLayout(){
        onView(withId(R.id.progress)).check(matches(isDisplayed()));
    }

    @Test
    fun testMainLayout(){
        onView(withId(R.id.tvTemp)).check(matches(isDisplayed()));
        onView(withId(R.id.tvCity)).check(matches(withText("Bangalore")))
    }

}