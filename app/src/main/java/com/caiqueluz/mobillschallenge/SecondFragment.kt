package com.caiqueluz.mobillschallenge

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.caiqueluz.mobillschallenge.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private val binding by lazy {
        FragmentSecondBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
