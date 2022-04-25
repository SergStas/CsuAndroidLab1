package com.example.domain.usecases.balance

import com.example.domain.models.Balance
import com.example.domain.repository.IBalanceRepository

class GetBalanceUseCase(
    private val repo: IBalanceRepository,
): IGetBalanceUseCase {
    override suspend fun getBalance(): Balance =
        repo.getBalance()
}