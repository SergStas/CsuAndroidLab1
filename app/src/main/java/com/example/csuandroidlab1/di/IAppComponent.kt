package com.example.csuandroidlab1.di

import com.example.csuandroidlab1.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton @Component(modules = [
    AppModule::class,
])
interface IAppComponent {
    fun inject(activity: MainActivity)
}