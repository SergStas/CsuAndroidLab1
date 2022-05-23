package com.example.csuandroidlab1.di

import com.example.domain.usecases.balance.GetBalanceUseCase
import com.example.domain.usecases.balance.IGetBalanceUseCase
import com.example.domain.usecases.gettariffs.DeleteTariffUsecase
import com.example.domain.usecases.gettariffs.GetTariffsUseCase
import com.example.domain.usecases.gettariffs.IDeleteTariffUsecase
import com.example.domain.usecases.gettariffs.IGetTariffsUseCase
import com.example.domain.usecases.getuserinfo.GetUserInfoUseCase
import com.example.domain.usecases.getuserinfo.IGetUserInfoUseCase
import dagger.Binds
import dagger.Module

@Module
abstract class UsecaseModule {
    @Binds
    abstract fun bindGetTariffs(getTariffsUseCase: GetTariffsUseCase): IGetTariffsUseCase

    @Binds
    abstract fun bindGetBalance(getBalanceUseCase: GetBalanceUseCase): IGetBalanceUseCase

    @Binds
    abstract fun bindGetUser(getUserInfoUseCase: GetUserInfoUseCase): IGetUserInfoUseCase

    @Binds
    abstract fun bindDeleteTariff(deleteTariffUsecase: DeleteTariffUsecase): IDeleteTariffUsecase
}