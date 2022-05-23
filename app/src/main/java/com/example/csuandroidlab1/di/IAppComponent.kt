package com.example.csuandroidlab1.di

import com.example.csuandroidlab1.viewmodels.ViewModelFactory
import dagger.Component

@Component(modules = [
    AppModule::class,
    DataModule::class,
    NetworkModule::class,
    UsecaseModule::class,
    ViewModelModule::class,
])
interface IAppComponent {
    fun factory(): ViewModelFactory
}

