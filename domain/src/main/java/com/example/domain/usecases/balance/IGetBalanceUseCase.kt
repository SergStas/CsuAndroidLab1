package com.example.domain.usecases.balance

import com.example.domain.models.Balance

interface IGetBalanceUseCase {
    suspend fun getBalance(): Balance
}