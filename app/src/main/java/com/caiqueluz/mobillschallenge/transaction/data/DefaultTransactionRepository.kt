package com.caiqueluz.mobillschallenge.transaction.data

import com.caiqueluz.mobillschallenge.transaction.Transaction
import com.caiqueluz.mobillschallenge.transaction.main.TransactionType
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class DefaultTransactionRepository(
    private val dispatcher: CoroutineDispatcher
) : TransactionRepository {

    private val cache = mutableListOf<Transaction>()

    override suspend fun save(transaction: Transaction): Boolean {
        delay(500L)

        withContext(dispatcher) {
            cache.add(transaction)
        }

        return true
    }

    override suspend fun <TYPE : Transaction> get(description: String): TYPE {
        delay(500L)

        return withContext(dispatcher) {
            cache.first { it.description == description } as TYPE
        }
    }

    override suspend fun getAll(transactionType: TransactionType): List<Transaction> {
        return withContext(dispatcher) {
            cache.filter { transaction ->
                transactionType == TransactionType.of(transaction)
            }
        }
    }

    override suspend fun delete(description: String) {
        delay(500L)
    }

    override suspend fun deleteAll() {
        delay(500L)

        withContext(dispatcher) {
            cache.clear()
        }
    }
}
