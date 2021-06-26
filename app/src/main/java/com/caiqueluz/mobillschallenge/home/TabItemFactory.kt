package com.caiqueluz.mobillschallenge.home

import android.content.res.Resources
import com.caiqueluz.mobillschallenge.FirstFragment
import com.caiqueluz.mobillschallenge.R
import com.caiqueluz.mobillschallenge.SecondFragment

class TabItemFactory(
    private val resources: Resources
) {

    fun createItems(): List<TabItemVO> = listOf(
        TabItemVO(resources.getString(R.string.tab_item_home), HomeFragment()),
        TabItemVO(resources.getString(R.string.tab_item_expenses), FirstFragment()),
        TabItemVO(resources.getString(R.string.tab_item_revenue), SecondFragment())
    )
}
