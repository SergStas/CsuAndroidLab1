package com.example.data.repository

import com.example.data.dao.UserInfoDao
import com.example.data.models.UserInfoEntity
import com.example.domain.models.UserInfo
import com.example.domain.repository.IUserInfoRepository
import com.example.network.retrorfit.RetrofitClient
import javax.inject.Inject

class UserInfoRepository @Inject constructor(
    private val client: RetrofitClient,
    private val userDao: UserInfoDao
): IUserInfoRepository {
    override suspend fun getUserInfo(): UserInfo {
        val fromDb = userDao.getAll()
        return if (fromDb.isNotEmpty()) {
            val entity = fromDb[0]
            UserInfo(entity.firstName, entity.lastName, entity.address, entity.id)
        } else {
            val fromApi = client.getApi().getUserInfo()[0]
            val mapped = UserInfoEntity(fromApi.firstName, fromApi.lastName, fromApi.address, fromApi.id)
            userDao.saveAll(mapped)
            fromApi
        }
    }
}