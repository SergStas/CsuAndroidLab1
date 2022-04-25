package com.example.data

import com.example.domain.models.Balance
import com.example.domain.repository.IBalanceRepository
import com.example.network.retrorfit.ApiProvider

class BalanceRepository(
    private val apiProvider: ApiProvider,
): IBalanceRepository {
    override suspend fun getBalance(): Balance =
        apiProvider.getApi().getBalance()[0]
}