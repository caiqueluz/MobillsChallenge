package com.caiqueluz.mobillschallenge.revenue.data

interface RevenueRepository {

    suspend fun save(revenue: Revenue): Boolean

    suspend fun get(description: String): Revenue

    suspend fun getAll(): List<Revenue>
}
