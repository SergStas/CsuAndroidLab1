package com.example.csuandroidlab1.di

import com.example.csuandroidlab1.viewmodels.ViewModelFactory
import com.example.data.BalanceRepository
import com.example.data.TariffRepository
import com.example.data.UserInfoRepository
import com.example.domain.repository.IBalanceRepository
import com.example.domain.repository.ITariffRepository
import com.example.domain.repository.IUserInfoRepository
import com.example.domain.usecases.balance.GetBalanceUseCase
import com.example.domain.usecases.balance.IGetBalanceUseCase
import com.example.domain.usecases.gettariffs.GetTariffsUseCase
import com.example.domain.usecases.gettariffs.IGetTariffsUseCase
import com.example.domain.usecases.getuserinfo.GetUserInfoUseCase
import com.example.domain.usecases.getuserinfo.IGetUserInfoUseCase
import com.example.network.retrorfit.ApiProvider
import com.example.network.retrorfit.IApi
import com.example.network.retrorfit.RetrofitClient
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Provides @Singleton
    fun provideViewModelFactory(
        tariffsUseCase: IGetTariffsUseCase,
        balanceUseCase: IGetBalanceUseCase,
        userInfoUseCase: IGetUserInfoUseCase
    ): ViewModelFactory =
        ViewModelFactory(tariffsUseCase, userInfoUseCase, balanceUseCase)

    @Provides @Singleton
    fun provideRetrofitClient(): RetrofitClient =
        RetrofitClient()

    @Provides @Singleton
    fun provideApiProvider(client: RetrofitClient): ApiProvider =
        ApiProvider(client)

    @Provides @Singleton
    fun provideApi(apiProvider: ApiProvider): IApi =
        apiProvider.getApi()

    @Provides @Singleton
    fun provideUserInfoRepo(apiProvider: ApiProvider): IUserInfoRepository =
        UserInfoRepository(apiProvider)

    @Provides @Singleton
    fun provideBalanceRepo(apiProvider: ApiProvider): IBalanceRepository =
        BalanceRepository(apiProvider)

    @Provides @Singleton
    fun provideTariffRepo(apiProvider: ApiProvider): ITariffRepository =
        TariffRepository(apiProvider)

    @Provides @Singleton
    fun provideUserInfoUseCase(repo: IUserInfoRepository): IGetUserInfoUseCase =
        GetUserInfoUseCase(repo)

    @Provides @Singleton
    fun provideBalanceUseCase(repo: IBalanceRepository): IGetBalanceUseCase =
        GetBalanceUseCase(repo)

    @Provides @Singleton
    fun provideTariffUseCase(repo: ITariffRepository): IGetTariffsUseCase =
        GetTariffsUseCase(repo)
}