package com.caiqueluz.mobillschallenge.revenue.addrevenue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.caiqueluz.mobillschallenge.CurrencyTextWatcher
import com.caiqueluz.mobillschallenge.asValidBigDecimal
import com.caiqueluz.mobillschallenge.databinding.FragmentAddRevenueBinding
import com.caiqueluz.mobillschallenge.openKeyboard
import com.caiqueluz.mobillschallenge.revenue.data.Revenue
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class AddRevenueFragment : Fragment() {

    private val binding by lazy {
        FragmentAddRevenueBinding.inflate(layoutInflater)
    }

    private val viewModel by viewModel<AddRevenueViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.descriptionEditText.openKeyboard()

        setupObserver()
        setupCurrencyValue()
        setupCalendar()
        setupButton()
    }

    private fun setupObserver() {
        //
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

    private fun setupButton() {
        binding.button.setOnClickListener {
            val revenue = with(binding) {
                Revenue(
                    value = valueEditText.text.toString().asValidBigDecimal(),
                    description = descriptionEditText.text.toString(),
                    date = Date(calendar.date),
                    received = true
                )
            }

            Toast
                .makeText(requireActivity(), revenue.toString(), Toast.LENGTH_LONG)
                .show()

            viewModel.onButtonClicked()
        }
    }
}
