package com.example.csuandroidlab1.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.domain.models.Balance
import com.example.domain.models.Tariff
import com.example.domain.models.UserInfo
import com.example.domain.usecases.balance.IGetBalanceUseCase
import com.example.domain.usecases.gettariffs.IGetTariffsUseCase
import com.example.domain.usecases.getuserinfo.IGetUserInfoUseCase
import kotlinx.coroutines.launch

class MainViewModel(
    private val tariffsUseCase: IGetTariffsUseCase,
    private val userInfoUseCase: IGetUserInfoUseCase,
    private val balanceUseCase: IGetBalanceUseCase,
): AbstractMainViewModel() {
    override val balance = MutableLiveData<Balance>()
    override val tariffs = MutableLiveData<List<Tariff>>()
    override val userInfo = MutableLiveData<UserInfo>()
    override val isLoading = MutableLiveData(false)

    override fun refreshData() {
        viewModelScope.launch {
            isLoading.value = true
            balance.value = balanceUseCase.getBalance()
            tariffs.value = tariffsUseCase.getTariffs()
            userInfo.value = userInfoUseCase.getUserInfo()
            isLoading.value = false
        }
    }
}