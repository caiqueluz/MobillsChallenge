package com.caiqueluz.mobillschallenge.transaction.main

import androidx.annotation.IdRes
import com.caiqueluz.mobillschallenge.R
import com.caiqueluz.mobillschallenge.transaction.Transaction
import java.io.Serializable

sealed class TransactionFlow(
    @IdRes val destination: Int,
    val transactionType: TransactionType
) : Serializable {

    class AddTransaction(type: TransactionType) : TransactionFlow(
        R.id.add_transaction_fragment, type
    )

    class TransactionDetail(
        val transaction: Transaction
    ) : TransactionFlow(
        R.id.transaction_detail_fragment, TransactionType.of(transaction)
    )
}
