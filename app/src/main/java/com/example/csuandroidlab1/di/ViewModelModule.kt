package com.example.csuandroidlab1.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.csuandroidlab1.viewmodels.AbstractMainViewModel
import com.example.csuandroidlab1.viewmodels.MainViewModel
import com.example.csuandroidlab1.viewmodels.ViewModelFactory
import com.example.csuandroidlab1.viewmodels.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(AbstractMainViewModel::class)
    abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel
}