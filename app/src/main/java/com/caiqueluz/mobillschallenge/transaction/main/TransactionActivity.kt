package com.caiqueluz.mobillschallenge.transaction.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import com.caiqueluz.mobillschallenge.*
import com.caiqueluz.mobillschallenge.databinding.ActivityTransactionBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class TransactionActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityTransactionBinding.inflate(layoutInflater)
    }

    private val viewModel by viewModel<TransactionViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val transactionFlow = extra<TransactionFlow>(TRANSACTION_FLOW_KEY)
        viewModel.onFlowReceived(transactionFlow)

        setupObserver()
    }

    override fun onBackPressed() {
        super.onBackPressed()

        binding.root.closeKeyboard()
        finish()
    }

    private fun setupObserver() {
        viewModel.navigate.observe(this) { flow ->
            val navController: NavController =
                findFragmentViewNavController(R.id.transaction_navigation_container)

            navController.navigate(flow.destination)
        }
    }
}
