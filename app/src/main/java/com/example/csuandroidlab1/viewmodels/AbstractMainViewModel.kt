package com.example.csuandroidlab1.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.domain.models.Balance
import com.example.domain.models.Tariff
import com.example.domain.models.UserInfo

abstract class AbstractMainViewModel: ViewModel() {
    abstract val balance: LiveData<Balance>
    abstract val tariffs: LiveData<List<Tariff>>
    abstract val userInfo: LiveData<UserInfo>
    abstract val isLoading: LiveData<Boolean>

    abstract fun refreshData()
    abstract fun delete(tariff: Tariff)
}