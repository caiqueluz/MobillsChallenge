package com.caiqueluz.mobillschallenge.revenue.addrevenue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.caiqueluz.mobillschallenge.CurrencyTextWatcher
import com.caiqueluz.mobillschallenge.databinding.FragmentAddRevenueBinding
import com.caiqueluz.mobillschallenge.openKeyboard
import org.koin.androidx.viewmodel.ext.android.viewModel

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
        setupDescriptionValue()
        setupCurrencyValue()
        setupButton()
    }

    private fun setupObserver() {
        //
    }

    private fun setupDescriptionValue() {
        //
    }

    private fun setupCurrencyValue() {
        binding.valueEditText.addTextChangedListener(CurrencyTextWatcher())
    }

    private fun setupButton() {
        viewModel.onButtonClicked()
    }
}
