package com.caiqueluz.mobillschallenge.revenue.data

import kotlinx.coroutines.delay

class DefaultRevenueRepository : RevenueRepository {

    private val cache = mutableListOf<Revenue>()

    override suspend fun save(revenue: Revenue): Boolean {
        cache.add(revenue)
        delay(500L)

        return true
    }

    override suspend fun get(description: String): Revenue {
        delay(500L)

        return cache.first { it.description == description }
    }

    override suspend fun getAll(): List<Revenue> {
        delay(500L)

        return cache
    }

    override suspend fun delete(description: String) {
        delay(500L)
    }

    override suspend fun deleteAll() {
        delay(500L)

        cache.clear()
    }
}
