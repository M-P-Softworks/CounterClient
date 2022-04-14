package com.emotionfactry.counterclient.presentation.counter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.emotionfactry.counterclient.R
import com.emotionfactry.counterclient.databinding.FragmentCounterBinding
import com.emotionfactry.counterclient.databinding.FragmentSettingsBinding

class CounterFragment : Fragment(R.layout.fragment_counter) {

    private lateinit var binding: FragmentCounterBinding
    private val viewModel: CounterViewModel by viewModels()

    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        navController = findNavController()
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentCounterBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)
    }



    override fun onResume() {
        super.onResume()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    private fun observeViewModel(){
        binding.decreaseBtn.setOnClickListener {
            viewModel.decrementValue()
        }
        binding.increaseBtn.setOnClickListener {
            viewModel.incrementValue()
        }
        viewModel.counterValue.observe(viewLifecycleOwner){
            binding.counterValue.text = it.toString()
        }
    }
}