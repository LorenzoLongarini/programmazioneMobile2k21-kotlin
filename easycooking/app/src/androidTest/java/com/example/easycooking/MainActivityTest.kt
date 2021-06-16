package com.example.easycooking

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest{
//test per la verifica di visualizzazione del contenuto del main
    @Test
    fun mainView() {

        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }
//test per la verifica di visualizzazione di alcuni contenuti del main e dello switch alla
// base non registrata al click sulla relativa scritta
    @Test
    fun continua_senza_registrarti() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.titolo))
            .check(matches(isDisplayed()))

        onView(withId(R.id.senza_registrazione))
            .check(matches(isDisplayed()))

        onView(withId(R.id.senza_registrazione))
            .perform(click())

        onView(withId(R.id.non_reg))
            .check(matches(isDisplayed()))
    }

    @Test
    fun registrati() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.titolo))
            .check(matches(isDisplayed()))

        onView(withId(R.id.registrati_accedi))
            .check(matches(isDisplayed()))

        onView(withId(R.id.registrati_accedi))
            .perform(click())

        onView(withId(R.id.registrati))
            .check(matches(isDisplayed()))
    }

    @Test
    fun resetta_password() {

        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.titolo))
            .check(matches(isDisplayed()))

        onView(withId(R.id.password_dimenticata))
            .check(matches(isDisplayed()))

        onView(withId(R.id.password_dimenticata))
            .perform(click())

        onView(withId(R.id.reset))
            .check(matches(isDisplayed()))
    }
}