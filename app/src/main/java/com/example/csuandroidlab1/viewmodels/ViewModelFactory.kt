package com.example.csuandroidlab1.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.usecases.balance.IGetBalanceUseCase
import com.example.domain.usecases.gettariffs.IGetTariffsUseCase
import com.example.domain.usecases.getuserinfo.IGetUserInfoUseCase

class ViewModelFactory(
    private val tariffsUseCase: IGetTariffsUseCase,
    private val userInfoUseCase: IGetUserInfoUseCase,
    private val balanceUseCase: IGetBalanceUseCase,
): ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        MainViewModel(tariffsUseCase, userInfoUseCase, balanceUseCase) as T
}