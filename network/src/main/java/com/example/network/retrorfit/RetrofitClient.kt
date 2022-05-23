package com.example.network.retrorfit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class RetrofitClient @Inject constructor() {
    fun getApi(): IApi =
        Retrofit.Builder()
            .baseUrl("https://61f5894b62f1e300173c41ba.mockapi.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(IApi::class.java)
}