package com.emotionfactry.counterclient.presentation.counter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.emotionfactry.counterclient.databinding.FragmentSettingsBinding

class CounterFragment : Fragment() {

    private lateinit var binding: FragmentSettingsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentSettingsBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    private fun observeViewModel(){

    }
}