package com.caiqueluz.mobillschallenge

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.caiqueluz.mobillschallenge.databinding.ActivityAppBinding
import com.google.android.material.tabs.TabLayoutMediator

class AppActivity : AppCompatActivity() {

    private val tabItemFactory = TabItemFactory()

    private val binding by lazy {
        ActivityAppBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val tabItems = tabItemFactory.createItems()

        setupViewPager(fragments = tabItems.map { it.fragment })
        setupTabLayout(names = tabItems.map { it.name })
    }

    private fun setupTabLayout(names: List<String>) {
        with(binding) {
            TabLayoutMediator(tabBarLayout, viewPager) { tab, position ->
                tab.text = names[position]
            }
        }.attach()
    }

    private fun setupViewPager(fragments: List<Fragment>) {
        val adapter = TabAdapter(this, fragments)
        binding.viewPager.adapter = adapter
    }
}
