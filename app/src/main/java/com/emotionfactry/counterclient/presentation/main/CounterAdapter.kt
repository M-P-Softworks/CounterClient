package com.emotionfactry.counterclient.presentation.main

import androidx.recyclerview.widget.RecyclerView
import com.emotionfactry.counterclient.databinding.ListItemCounterBinding
import com.emotionfactry.data.model.Counter

class CounterAdapter (
    private val onClickAction: (item: Counter, position: Int) -> Unit
) : RecyclerView.Adapter<CounterViewHolder>() {

}

class CounterViewHolder(
    private val binding: ListItemCounterBinding,
    private val onClickAction: (item: Counter, position: Int) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    private lateinit var counter: Counter

    fun bind(item: Counter) {
        counter = item

        binding.itemClickerTitle.text = item.title

        binding.itemClickerSub.text

        binding.itemClickerCount.text = item.value.toString()

        binding.itemClickerIcon
    }


}