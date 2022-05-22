package com.example.csuandroidlab1.di

import com.example.domain.usecases.gettariffs.GetTariffsUseCase
import com.example.domain.usecases.gettariffs.IGetTariffsUseCase
import dagger.Binds
import dagger.Module

@Module
interface BindModule {
    @Binds
    fun bind(usecase: GetTariffsUseCase): IGetTariffsUseCase
}