package com.emotionfactry.counterclient.presentation.main

import androidx.recyclerview.widget.RecyclerView
import com.emotionfactry.counterclient.databinding.ListItemCounterBinding
import com.emotionfactry.data.model.Counter

class CounterAdapter (
    private val onClickAction: (item: Counter, position: Int) -> Unit
) : RecyclerView.Adapter<>() {

}

class CounterViewHolder(
    private val binding: ListItemCounterBinding,
    private val onClickAction: (item: Counter, position: Int) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

}