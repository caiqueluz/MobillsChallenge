package com.caiqueluz.mobillschallenge.home

import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.caiqueluz.mobillschallenge.injectModule
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.mock
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.androidx.viewmodel.dsl.viewModel

@RunWith(AndroidJUnit4::class)
class HomeActivityTest {

    private val fakeTabItemsList = listOf(
        TabItemVO("Despesas", Fragment()),
        TabItemVO("Receitas", Fragment())
    )

    private val mockViewModel = mock<HomeViewModel> {
        on { tabItems } doAnswer {
            val liveData = MutableLiveData<List<TabItemVO>>()
            liveData.postValue(fakeTabItemsList)

            liveData
        }
    }

    @Before
    fun before() {
        injectTestModule()
        launch()
    }

    @Test
    fun whenStarted_verifyExpensesTabItemIsDisplayed() {
        onView(withText("Despesas")).check(
            matches(isDisplayed())
        )
    }

    @Test
    fun whenStarted_verifyRevenuesTabItemIsDisplayed() {
        onView(withText("Receitas")).check(
            matches(isDisplayed())
        )
    }

    private fun launch(): ActivityScenario<HomeActivity> =
        ActivityScenario.launch(HomeActivity::class.java)

    private fun injectTestModule() {
        injectModule {
            viewModel { mockViewModel }
        }
    }
}
