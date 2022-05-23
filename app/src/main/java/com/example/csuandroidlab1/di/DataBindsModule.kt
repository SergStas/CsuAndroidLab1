package com.example.csuandroidlab1.di

import com.example.data.repository.BalanceRepository
import com.example.data.repository.TariffRepository
import com.example.data.repository.UserInfoRepository
import com.example.domain.repository.IBalanceRepository
import com.example.domain.repository.ITariffRepository
import com.example.domain.repository.IUserInfoRepository
import dagger.Binds
import dagger.Module

@Module
abstract class DataBindsModule {
    @Binds
    abstract fun bindBalanceRepo(balanceRepository: BalanceRepository): IBalanceRepository

    @Binds
    abstract fun bindUserRepo(userRepository: UserInfoRepository): IUserInfoRepository

    @Binds
    abstract fun bindTariffsRepo(tariffsRepository: TariffRepository): ITariffRepository
}