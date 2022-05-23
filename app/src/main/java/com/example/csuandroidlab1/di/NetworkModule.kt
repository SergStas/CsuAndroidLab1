package com.example.csuandroidlab1.di

import com.example.network.retrorfit.IApi
import com.example.network.retrorfit.RetrofitClient
import dagger.Module
import dagger.Provides

@Module
class NetworkModule {
    @Provides
    fun provideApi(client: RetrofitClient): IApi = client.getApi()
}