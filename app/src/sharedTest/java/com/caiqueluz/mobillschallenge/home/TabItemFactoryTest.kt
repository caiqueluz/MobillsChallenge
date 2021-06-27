package com.caiqueluz.mobillschallenge.home

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.caiqueluz.mobillschallenge.expense.ExpenseFragment
import com.caiqueluz.mobillschallenge.revenue.allrevenues.AllRevenuesFragment
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TabItemFactoryTest {

    private val resources = ApplicationProvider.getApplicationContext<Context>().resources
    private val factory = TabItemFactory(resources)

    private val items = factory.createItems()

    @Test
    fun whenCreateItemsIsCalled_verifyFirstItemTabNameIsCorrect() {
        val expected = "Geral"
        val actual = items[0].name

        assertEquals(expected, actual)
    }

    @Test
    fun whenCreateItemsIsCalled_verifyFirstItemTabFragmentIsCorrect() {
        val expected = HomeFragment::class.java
        val actual = items[0].fragment::class.java

        assertEquals(expected, actual)
    }

    @Test
    fun whenCreateItemsIsCalled_verifySecondItemTabNameIsCorrect() {
        val expected = "Despesas"
        val actual = items[1].name

        assertEquals(expected, actual)
    }

    @Test
    fun whenCreateItemsIsCalled_verifySecondItemTabFragmentIsCorrect() {
        val expected = ExpenseFragment::class.java
        val actual = items[1].fragment::class.java

        assertEquals(expected, actual)
    }

    @Test
    fun whenCreateItemsIsCalled_verifyThirdItemTabNameIsCorrect() {
        val expected = "Receitas"
        val actual = items[2].name

        assertEquals(expected, actual)
    }

    @Test
    fun whenCreateItemsIsCalled_verifyThirdItemTabFragmentIsCorrect() {
        val expected = AllRevenuesFragment::class.java
        val actual = items[2].fragment::class.java

        assertEquals(expected, actual)
    }
}
