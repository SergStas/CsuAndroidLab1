package com.example.csuandroidlab1.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.csuandroidlab1.databinding.RvTarifBinding

class Adapter: ListAdapter<Item, ItemViewHolder>(
    object : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean =
            oldItem == newItem
        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean =
            oldItem == newItem
    }
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder =
        ItemViewHolder(RvTarifBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false,
        ))

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) = holder.bind(getItem(position))
}