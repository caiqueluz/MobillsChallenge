package com.caiqueluz.mobillschallenge.revenue.data

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class DefaultRevenueRepository(
    private val dispatcher: CoroutineDispatcher
) : RevenueRepository {

    private val cache = mutableListOf<Revenue>()

    override suspend fun save(revenue: Revenue): Boolean {
        delay(500L)

        withContext(dispatcher) {
            cache.add(revenue)
        }

        return true
    }

    override suspend fun get(description: String): Revenue {
        delay(500L)

        return withContext(dispatcher) {
            cache.first { it.description == description }
        }
    }

    override suspend fun getAll(): List<Revenue> {
        return withContext(dispatcher) {
            cache
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
