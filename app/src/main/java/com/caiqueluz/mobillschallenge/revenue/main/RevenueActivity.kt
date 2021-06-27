package com.caiqueluz.mobillschallenge.revenue.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.caiqueluz.mobillschallenge.R
import com.caiqueluz.mobillschallenge.REVENUE_FLOW_KEY
import com.caiqueluz.mobillschallenge.databinding.ActivityRevenueBinding
import com.caiqueluz.mobillschallenge.extra
import org.koin.androidx.viewmodel.ext.android.viewModel

class RevenueActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityRevenueBinding.inflate(layoutInflater)
    }

    private val viewModel by viewModel<RevenueViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val flow = extra<RevenueFlow>(REVENUE_FLOW_KEY)
        viewModel.onFlowReceived(flow)

        setupObserver()
    }

    private fun setupObserver() {
        viewModel.navigate.observe(this) { destination ->
            val navController = findFragmentViewNavController()
            navController.navigate(destination)
        }
    }
}

/**
 *
 * FragmentContainerView navigation bug. See this: https://stackoverflow.com/a/59275182
 *
 */
private fun FragmentActivity.findFragmentViewNavController(): NavController {
    val navHostFragment = supportFragmentManager
        .findFragmentById(R.id.revenue_navigation_container) as NavHostFragment

    return navHostFragment.navController
}
