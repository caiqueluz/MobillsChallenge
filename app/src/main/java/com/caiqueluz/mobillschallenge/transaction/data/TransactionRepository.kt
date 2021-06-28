package com.caiqueluz.mobillschallenge.transaction.data

import com.caiqueluz.mobillschallenge.transaction.Transaction
import com.caiqueluz.mobillschallenge.transaction.main.TransactionType

interface TransactionRepository {

    suspend fun save(transaction: Transaction): Boolean

    suspend fun <TYPE : Transaction> get(description: String): TYPE

    suspend fun getAll(transactionType: TransactionType): List<Transaction>

    suspend fun delete(description: String)

    suspend fun deleteAll()
}
