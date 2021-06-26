package com.caiqueluz.mobillschallenge

import android.content.res.Resources

class TabItemFactory(
    private val resources: Resources
) {

    fun createItems(): List<TabItemVO> = listOf(
        TabItemVO(resources.getString(R.string.tab_item_home), HomeFragment()),
        TabItemVO(resources.getString(R.string.tab_item_expenses), FirstFragment()),
        TabItemVO(resources.getString(R.string.tab_item_revenue), SecondFragment())
    )
}
