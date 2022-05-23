package com.example.csuandroidlab1.ui

import androidx.recyclerview.widget.RecyclerView
import com.example.csuandroidlab1.databinding.RvTarifBinding

class ItemViewHolder(private val binding: RvTarifBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Item) {
        binding.nazvanie.text = item.title
        binding.skorost.text = item.subtitle
        binding.cena.text = "${item.price} ₽"
        binding.delete.setOnClickListener {
            item.onClick()
        }
    }
}