package com.caiqueluz.mobillschallenge.home

import android.content.res.Resources
import com.caiqueluz.mobillschallenge.R
import com.caiqueluz.mobillschallenge.transaction.alltransactions.AllTransactionsFragment
import com.caiqueluz.mobillschallenge.transaction.main.TransactionType

class TabItemFactory(
    private val resources: Resources
) {

    fun createItems(): List<TabItemVO> = listOf(
        createExpensesTabItem(),
        createRevenuesTabItem()
    )

    private fun createExpensesTabItem(): TabItemVO =
        TabItemVO(
            resources.getString(R.string.tab_item_expenses),
            AllTransactionsFragment.withExtras(TransactionType.EXPENSE)
        )

    private fun createRevenuesTabItem(): TabItemVO =
        TabItemVO(
            resources.getString(R.string.tab_item_revenue),
            AllTransactionsFragment.withExtras(TransactionType.REVENUE)
        )
}
