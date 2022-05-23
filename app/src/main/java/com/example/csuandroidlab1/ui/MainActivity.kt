package com.example.csuandroidlab1.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.csuandroidlab1.R
import com.example.csuandroidlab1.databinding.ActivityMainBinding
import com.example.csuandroidlab1.viewmodels.AbstractMainViewModel
import com.example.csuandroidlab1.factory
import com.example.domain.models.Tariff

class MainActivity: AppCompatActivity() {
    private lateinit var adapter: Adapter
    private lateinit var binding: ActivityMainBinding

    private val viewModel by viewModels<AbstractMainViewModel> { factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setView()
        setAdapter()
        subscribe()
    }

    override fun onResume() {
        super.onResume()
        viewModel.refreshData()
    }

    private fun subscribe() {
        viewModel.isLoading.observe(this) {
            binding.loading.isVisible = it
        }
        viewModel.tariffs.observe(this) { list ->
            setTariffs(list.map { item -> mapTariffToItem(item) })
        }
        viewModel.balance.observe(this) {
            with(binding) {
                balanceSum.text = it.balance.toString()
                kOplate.text = getString(R.string.k_oplate).format(it.nextPay)
                ls.text = getString(R.string.ls).format(it.accNum)
            }
        }
        viewModel.userInfo.observe(this) {
            with(binding) {
                name.text = getString(R.string.name_ph).format(it.firstName, it.lastName)
                adres.text = it.address
            }
        }
    }

    private fun mapTariffToItem(tariff: Tariff) =
        Item(
            title = tariff.title,
            subtitle = tariff.desc,
            price = tariff.cost,
            onClick = { viewModel.delete(tariff) },
        )

    private fun setTariffs(list: List<Item>) =
        adapter.submitList(list)

    private fun setView() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setAdapter() {
        adapter = Adapter()
        binding.rv.adapter = adapter
        binding.rv.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false,
        )
    }
}

