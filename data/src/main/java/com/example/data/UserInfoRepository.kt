package com.example.data

import com.example.domain.models.UserInfo
import com.example.domain.repository.IUserInfoRepository
import com.example.network.retrorfit.ApiProvider

class UserInfoRepository(
    private val apiProvider: ApiProvider,
): IUserInfoRepository {
    override suspend fun getUserInfo(): UserInfo {
        return apiProvider.getApi().getUserInfo()[0]
    }
}