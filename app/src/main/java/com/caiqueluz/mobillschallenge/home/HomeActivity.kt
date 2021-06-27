package com.caiqueluz.mobillschallenge.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.caiqueluz.mobillschallenge.databinding.ActivityHomeBinding
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity() {

    private val viewModel by viewModel<HomeViewModel>()

    private val binding by lazy {
        ActivityHomeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupObserver()
    }

    private fun setupObserver() {
        viewModel.tabItems.observe(this) { tabItems ->
            setupViewPager(tabItems.map { it.fragment })
            setupTabLayout(tabItems.map { it.name })
        }
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
