package com.caiqueluz.mobillschallenge

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.caiqueluz.mobillschallenge.transaction.main.TransactionFlow
import com.nhaarman.mockitokotlin2.mock
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class IntentFactoryTest {

    private val context = ApplicationProvider.getApplicationContext<Context>()
    private val factory = IntentFactory(context)

    @Test
    fun whenCreateTransactionIntentIsCalled_verifyIntentComponentNameIsCorrect() {
        val expected = ".transaction.main.TransactionActivity"
        val actual = factory.createTransactionIntent(mock()).component?.shortClassName

        assertEquals(expected, actual)
    }

    @Test
    fun whenCreateTransactionIntentIsCalled_verifyTransactionFlowIsCorrect() {
        val expected = mock<TransactionFlow>()
        val actual = factory.createTransactionIntent(expected).extras?.get(
            TRANSACTION_FLOW_KEY
        )

        assertEquals(expected, actual)
    }
}
