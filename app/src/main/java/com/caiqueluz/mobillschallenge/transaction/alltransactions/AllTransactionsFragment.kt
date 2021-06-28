package com.caiqueluz.mobillschallenge.transaction.alltransactions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.caiqueluz.mobillschallenge.databinding.FragmentAllTransactionsBinding
import com.caiqueluz.mobillschallenge.extra
import com.caiqueluz.mobillschallenge.transaction.main.TransactionType
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val TRANSACTION_TYPE_KEY = "TRANSACTION_TYPE"

class AllTransactionsFragment : Fragment() {

    private val binding by lazy {
        FragmentAllTransactionsBinding.inflate(layoutInflater)
    }

    private val viewModel by viewModel<AllTransactionsViewModel>()

    private val transactionType = extra<TransactionType>(TRANSACTION_TYPE_KEY)

    companion object {

        fun withExtras(transactionType: TransactionType): AllTransactionsFragment =
            AllTransactionsFragment().apply {
                val bundle = Bundle()
                bundle.putSerializable(TRANSACTION_TYPE_KEY, transactionType)

                arguments = bundle
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupObservers()
        setupAddButton()
    }

    override fun onStart() {
        super.onStart()

        viewModel.onStart(transactionType)
    }

    private fun setupObservers() {
        viewModel.navigate.observe(viewLifecycleOwner) { intent ->
            startActivity(intent)
        }

        viewModel.transactions.observe(viewLifecycleOwner) { transactions ->
            val adapter = AllTransactionsAdapter(context = requireActivity(), transactions)
            binding.recyclerView.adapter = adapter
        }
    }

    private fun setupAddButton() {
        binding.addButton.setOnClickListener {
            viewModel.onAddButtonClicked(transactionType)
        }
    }
}
