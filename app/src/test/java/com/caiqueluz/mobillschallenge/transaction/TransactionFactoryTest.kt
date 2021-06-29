package com.caiqueluz.mobillschallenge.transaction

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.caiqueluz.mobillschallenge.transaction.addtransaction.TransactionFactory
import com.nhaarman.mockitokotlin2.mock
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*

@RunWith(AndroidJUnit4::class)
class TransactionFactoryTest {

    private val factory = TransactionFactory()

    @Test
    fun whenCreateRevenueTransactionIsCalled_verifyRevenueValueIsCorrect() {
        val expected = "0.0"
        val actual = factory.createRevenueTransaction(
            value = expected, "description", mock(), true
        ).value

        assertEquals(expected.toBigDecimal(), actual)
    }

    @Test
    fun whenCreateRevenueTransactionIsCalled_verifyRevenueDescriptionIsCorrect() {
        val expected = "description"
        val actual = factory.createRevenueTransaction(
            "0.0", description = expected, mock(), true
        ).description

        assertEquals(expected, actual)
    }

    @Test
    fun whenCreateRevenueTransactionIsCalled_verifyRevenueDateIsCorrect() {
        val expected = mock<Date>()
        val actual = factory.createRevenueTransaction(
            "0.0", "description", date = expected, true
        ).date

        assertEquals(expected, actual)
    }

    @Test
    fun whenCreateRevenueTransactionIsCalled_verifyRevenueReceivedIsCorrect() {
        val expected = true
        val actual = factory.createRevenueTransaction(
            "0.0", "description", mock(), received = expected
        ).received

        assertEquals(expected, actual)
    }

    @Test
    fun whenCreateExpenseTransactionIsCalled_verifyExpenseValueIsCorrect() {
        val expected = "0.0"
        val actual = factory.createExpenseTransaction(
            value = expected, "description", mock(), true
        ).value

        assertEquals(expected.toBigDecimal(), actual)
    }

    @Test
    fun whenCreateExpenseTransactionIsCalled_verifyExpenseDescriptionIsCorrect() {
        val expected = "description"
        val actual = factory.createExpenseTransaction(
            "0.0", description = expected, mock(), true
        ).description

        assertEquals(expected, actual)
    }

    @Test
    fun whenCreateExpenseTransactionIsCalled_verifyExpenseDateIsCorrect() {
        val expected = mock<Date>()
        val actual = factory.createExpenseTransaction(
            "0.0", "description", date = expected, true
        ).date

        assertEquals(expected, actual)
    }

    @Test
    fun whenCreateExpenseTransactionIsCalled_verifyExpensePaidIsCorrect() {
        val expected = true
        val actual = factory.createExpenseTransaction(
            "0.0", "description", mock(), paid = expected
        ).paid

        assertEquals(expected, actual)
    }
}
