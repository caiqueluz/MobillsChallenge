package com.caiqueluz.mobillschallenge.revenue.addrevenue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.caiqueluz.mobillschallenge.databinding.FragmentAddRevenueBinding

class AddRevenueFragment : Fragment() {

    private val binding by lazy {
        FragmentAddRevenueBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
