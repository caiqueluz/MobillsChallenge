package com.caiqueluz.mobillschallenge.revenue.allrevenues

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.caiqueluz.mobillschallenge.databinding.FragmentAllRevenuesBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class AllRevenuesFragment : Fragment() {

    private val binding by lazy {
        FragmentAllRevenuesBinding.inflate(layoutInflater)
    }

    private val viewModel by viewModel<AllRevenuesViewModel>()

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

        viewModel.onStart()
    }

    private fun setupObservers() {
        viewModel.navigate.observe(viewLifecycleOwner) { intent ->
            startActivity(intent)
        }

        viewModel.revenues.observe(viewLifecycleOwner) { revenues ->
            val adapter = AllRevenuesAdapter(context = requireActivity(), revenues)
            binding.recyclerView.adapter = adapter
        }
    }

    private fun setupAddButton() {
        binding.addButton.setOnClickListener {
            viewModel.onAddButtonClicked()
        }
    }
}
