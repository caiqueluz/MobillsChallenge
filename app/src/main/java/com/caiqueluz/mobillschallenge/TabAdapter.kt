package com.caiqueluz.mobillschallenge

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabAdapter(
    container: FragmentActivity,
    private val fragments: List<Fragment>
) : FragmentStateAdapter(container) {

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]
}
