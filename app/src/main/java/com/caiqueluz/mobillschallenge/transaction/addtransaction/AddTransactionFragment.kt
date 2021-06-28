package com.caiqueluz.mobillschallenge.transaction.addtransaction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.caiqueluz.mobillschallenge.*
import com.caiqueluz.mobillschallenge.databinding.FragmentAddTransactionBinding
import com.caiqueluz.mobillschallenge.transaction.main.TransactionFlow
import com.caiqueluz.mobillschallenge.transaction.main.TransactionType.EXPENSE
import com.caiqueluz.mobillschallenge.transaction.main.TransactionType.REVENUE
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class AddTransactionFragment : Fragment() {

    private val binding by lazy {
        FragmentAddTransactionBinding.inflate(layoutInflater)
    }

    private val viewModel by viewModel<AddTransactionViewModel>()

    private val transactionType by lazy {
        requireActivity()
            .extra<TransactionFlow>(TRANSACTION_FLOW_KEY)
            .transactionType
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.descriptionEditText.openKeyboard()

        setupToolbar()
        setupObserver()
        setupCurrencyValue()
        setupCalendar()
        setupButton()
        setupStatusCheckbox()
    }

    private fun setupToolbar() {
        when (transactionType) {
            REVENUE -> updateToolbarText(R.string.add_revenue_toolbar_title)
            EXPENSE -> updateToolbarText(R.string.add_expense_toolbar_title)
        }

        enableToolbarBackButton(binding.toolbar)

        binding.toolbar.setNavigationOnClickListener {
            requireActivity().finish()
        }
    }

    private fun updateToolbarText(@StringRes titleResId: Int) {
        val title = getString(titleResId)
        binding.toolbar.title = title
    }

    private fun setupObserver() {
        viewModel.addTransaction.observe(viewLifecycleOwner) { result ->
            Toast
                .makeText(requireActivity(), "Result: $result", Toast.LENGTH_LONG)
                .show()
        }
    }

    private fun setupCurrencyValue() {
        binding.valueEditText.addTextChangedListener(CurrencyTextWatcher())
    }

    private fun setupCalendar() {
        val appCalendar = Calendar.getInstance()

        binding.calendar.setOnDateChangeListener { view, year, month, dayOfMonth ->
            appCalendar.set(year, month, dayOfMonth)
            view.date = appCalendar.timeInMillis
        }
    }

    private fun setupStatusCheckbox() {
        when (transactionType) {
            REVENUE -> updateStatusCheckboxText(R.string.revenue_received_label)
            EXPENSE -> updateStatusCheckboxText(R.string.expense_paid_label)
        }
    }

    private fun updateStatusCheckboxText(@StringRes labelResId: Int) {
        val label = getString(labelResId)
        binding.statusCheckboxText.text = label
    }

    private fun setupButton() {
        binding.button.setOnClickListener {
            viewModel.onAddTransactionRequested(
                value(), description(), date(), statusCheckboxValue()
            )
        }
    }

    private fun value() = binding.valueEditText.text.toString()

    private fun description() = binding.descriptionEditText.text.toString()

    private fun date() = Date(binding.calendar.date)

    private fun statusCheckboxValue() = binding.statusCheckbox.isChecked
}
