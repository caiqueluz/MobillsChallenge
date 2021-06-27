package com.caiqueluz.mobillschallenge.expense

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.caiqueluz.mobillschallenge.databinding.FragmentExpenseBinding

class ExpenseFragment : Fragment() {

    private val binding by lazy {
        FragmentExpenseBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupAddButton()
    }

    private fun setupAddButton() {
        binding.addButton.setOnClickListener {
            //
        }
    }
}
