package com.example.csuandroidlab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.csuandroidlab1.databinding.ActivityMainBinding
import com.example.csuandroidlab1.databinding.RvTarifBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = Adapter()
        binding.rv.adapter = adapter
        binding.rv.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false,
        )

        val list = listOf(
            Item(
                "Тариф \"Улыбка\" (беcплатный интернет)",
                "Cкороcть до 100 Мбит/c",
                0,
            ),
            Item(
                "Тариф \"Груcтинка\" (платный интернет)",
                "Cкороcть до 10 Мбит/c",
                1000,
            ),
            Item(
                "Тариф \"Без интернета\" (до 100 каналов кабельного телевидения)",
                "Cкороcть до 0 бит/c",
                2500,
            ),
        )

        adapter.submitList(list)
    }
}

class Adapter: ListAdapter<Item, VH>(
    object : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean =
            oldItem == newItem
        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean =
            oldItem == newItem
    }
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH =
        VH(RvTarifBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false,
        ))

    override fun onBindViewHolder(holder: VH, position: Int) = holder.bind(getItem(position))
}

data class Item(
    val title: String,
    val subtitle: String,
    val price: Int,
)

class VH(private val binding: RvTarifBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Item) {
        binding.nazvanie.text = item.title
        binding.skorost.text = item.subtitle
        binding.cena.text = "${item.price} ₽"
    }
}