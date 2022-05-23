package com.example.csuandroidlab1

import android.app.Application
import com.example.csuandroidlab1.di.AppModule
import com.example.csuandroidlab1.di.DaggerIAppComponent
import com.example.csuandroidlab1.di.IAppComponent

class App: Application() {
    lateinit var appComponent: IAppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerIAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }
}