package com.caiqueluz.mobillschallenge

import android.content.Context
import android.content.Intent
import com.caiqueluz.mobillschallenge.transaction.main.TransactionActivity
import com.caiqueluz.mobillschallenge.transaction.main.TransactionFlow

const val TRANSACTION_FLOW_KEY = "TRANSACTION_FLOW"

class IntentFactory(
    private val context: Context
) {

    fun createTransactionIntent(transactionFlow: TransactionFlow): Intent {
        val intent = Intent(context, TransactionActivity::class.java)
        intent.putExtra(TRANSACTION_FLOW_KEY, transactionFlow)

        return intent
    }
}
