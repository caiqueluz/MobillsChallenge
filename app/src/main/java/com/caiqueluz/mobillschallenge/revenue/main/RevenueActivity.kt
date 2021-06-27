package com.caiqueluz.mobillschallenge.revenue.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.caiqueluz.mobillschallenge.*
import com.caiqueluz.mobillschallenge.databinding.ActivityRevenueBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class RevenueActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityRevenueBinding.inflate(layoutInflater)
    }

    private val viewModel by viewModel<RevenueViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupToolbar()

        val flow = extra<RevenueFlow>(REVENUE_FLOW_KEY)
        viewModel.onFlowReceived(flow)

        setupObserver()
    }

    override fun onBackPressed() {
        super.onBackPressed()

        finish()
    }

    private fun setupToolbar() {
        enableToolbarBackButton(binding.toolbar)

        binding.toolbar.setNavigationOnClickListener {
            finish()
        }
    }

    private fun setupObserver() {
        viewModel.navigate.observe(this) { destination ->
            val navController = findFragmentViewNavController(R.id.revenue_navigation_container)
            navController.navigate(destination)
        }
    }
}
