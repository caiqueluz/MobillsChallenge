package com.caiqueluz.mobillschallenge.expense

import com.caiqueluz.mobillschallenge.transaction.alltransactions.TransactionVO
import com.caiqueluz.mobillschallenge.transaction.main.TransactionType

class ExpenseVO(
    override val value: String,
    override val description: String,
    override val date: String,
    val paid: String
) : TransactionVO(value, description, date, TransactionType.EXPENSE)
