package com.caiqueluz.mobillschallenge.home

import android.content.res.Resources
import com.caiqueluz.mobillschallenge.expense.ExpenseFragment
import com.caiqueluz.mobillschallenge.R
import com.caiqueluz.mobillschallenge.revenue.allrevenues.AllRevenuesFragment

class TabItemFactory(
    private val resources: Resources
) {

    fun createItems(): List<TabItemVO> = listOf(
        TabItemVO(resources.getString(R.string.tab_item_home), HomeFragment()),
        TabItemVO(resources.getString(R.string.tab_item_expenses), ExpenseFragment()),
        TabItemVO(resources.getString(R.string.tab_item_revenue), AllRevenuesFragment())
    )
}
