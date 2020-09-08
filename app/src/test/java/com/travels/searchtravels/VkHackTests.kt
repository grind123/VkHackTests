package com.travels.searchtravels

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.api.services.vision.v1.model.LatLng
import com.travels.searchtravels.activity.MainActivity
import com.travels.searchtravels.utils.Constants
import com.travels.searchtravels.activity.ChipActivity
import org.hamcrest.core.StringContains.*
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class VkHackTests {

    @Test
    fun seaLoadCategoryTest() {
        val expectedCityEN = "Rimini"
        val expectedCityRU = "Римини"
        val category = "sea"
        val scenario = launch(MainActivity::class.java)
        scenario.moveToState(Lifecycle.State.CREATED)
        scenario.moveToState(Lifecycle.State.RESUMED)
        scenario.onActivity { activity ->
            activity.loadByCategory(category)
        }
        Assert.assertEquals(Constants.PICKED_CITY_EN, expectedCityEN)
        Assert.assertEquals(Constants.PICKED_CITY_RU, expectedCityRU)
    }

    @Test
    fun oceanLoadCategoryTest() {
        val expectedCityEN = "Rimini"
        val expectedCityRU = "Римини"
        val category = "ocean"
        val scenario = launch(MainActivity::class.java)
        scenario.moveToState(Lifecycle.State.CREATED)
        scenario.moveToState(Lifecycle.State.RESUMED)
        scenario.onActivity { activity ->
            activity.loadByCategory(category)
        }
        Assert.assertEquals(Constants.PICKED_CITY_EN, expectedCityEN)
        Assert.assertEquals(Constants.PICKED_CITY_RU, expectedCityRU)
    }
    @Test
    fun beachLoadCategoryTest() {
        val expectedCityEN = "Rimini"
        val expectedCityRU = "Римини"
        val category = "beach"
        val scenario = launch(MainActivity::class.java)
        scenario.moveToState(Lifecycle.State.CREATED)
        scenario.moveToState(Lifecycle.State.RESUMED)
        scenario.onActivity { activity ->
            activity.loadByCategory(category)
        }
        Assert.assertEquals(Constants.PICKED_CITY_EN, expectedCityEN)
        Assert.assertEquals(Constants.PICKED_CITY_RU, expectedCityRU)
    }

    @Test
    fun mountainLoadCategoryTest() {
        val expectedCityEN = "Sochi"
        val expectedCityRU = "Сочи"
        val category = "mountain"
        val scenario = launch(MainActivity::class.java)
        scenario.moveToState(Lifecycle.State.CREATED)
        scenario.moveToState(Lifecycle.State.RESUMED)
        scenario.onActivity { activity ->
            activity.loadByCategory(category)
        }
        Assert.assertEquals(Constants.PICKED_CITY_EN, expectedCityEN)
        Assert.assertEquals(Constants.PICKED_CITY_RU, expectedCityRU)
    }

    @Test
    fun snowLoadCategoryTest() {
        val expectedCityEN = "Helsinki"
        val expectedCityRU = "Хельсинки"
        val category = "snow"
        val scenario = launch(MainActivity::class.java)
        scenario.moveToState(Lifecycle.State.CREATED)
        scenario.moveToState(Lifecycle.State.RESUMED)
        scenario.onActivity { activity ->
            activity.loadByCategory(category)
        }
        Assert.assertEquals(Constants.PICKED_CITY_EN, expectedCityEN)
        Assert.assertEquals(Constants.PICKED_CITY_RU, expectedCityRU)
    }

    @Test
    fun someLoadCategoryTest() {
        val expectedCityEN = "Rimini"
        val expectedCityRU = "Римини"
        val category = "someWrongCategory"
        val scenario = launch(MainActivity::class.java)
        scenario.moveToState(Lifecycle.State.CREATED)
        scenario.moveToState(Lifecycle.State.RESUMED)
        scenario.onActivity { activity ->
            activity.loadByCategory(category)
        }
        Assert.assertEquals(Constants.PICKED_CITY_EN, expectedCityEN)
        Assert.assertEquals(Constants.PICKED_CITY_RU, expectedCityRU)
    }


    /**
     * This test using mock JSON response from service inside application code
     * (потому что с ключами я так и не смог разобраться)
     */
    @Test
    fun checkPriceTest(){
        Constants.PICKED_CITY_EN = "Moscow"
        val expectedCountry = "Russia"
        val expectedPrice = 6590
        val scenario = launch(ChipActivity::class.java)
        scenario.moveToState(Lifecycle.State.CREATED)
        scenario.moveToState(Lifecycle.State.STARTED)
        scenario.moveToState(Lifecycle.State.RESUMED)

        Espresso.onView(withId(R.id.airticketTV)).check(matches(withText(containsString("$expectedPrice"))))
        Espresso.onView(withId(R.id.countryTV)).check(matches(withText(containsString("$expectedCountry"))))
    }

}