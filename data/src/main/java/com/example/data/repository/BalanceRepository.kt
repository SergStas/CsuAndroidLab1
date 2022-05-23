package com.example.data.repository

import com.example.data.dao.BalanceDao
import com.example.data.models.BalanceEntity
import com.example.domain.models.Balance
import com.example.domain.repository.IBalanceRepository
import com.example.network.retrorfit.RetrofitClient
import javax.inject.Inject

class BalanceRepository @Inject constructor(
    private val client: RetrofitClient,
    private val balanceDao: BalanceDao,
): IBalanceRepository {
    override suspend fun getBalance(): Balance {
        val fromDb = balanceDao.getAll()
        return if (fromDb.isNotEmpty()) {
            val entity = fromDb[0]
            Balance(entity.accNum, entity.balance, entity.nextPay, entity.id)
        } else {
            val fromApi = client.getApi().getBalance()[0]
            val mapped = BalanceEntity(fromApi.accNum, fromApi.balance, fromApi.nextPay, fromApi.id)
            balanceDao.saveAll(mapped)
            fromApi
        }
    }
}