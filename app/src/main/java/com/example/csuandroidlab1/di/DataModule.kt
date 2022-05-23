package com.example.csuandroidlab1.di

import android.content.Context
import androidx.room.Room
import com.example.data.Database
import com.example.data.dao.BalanceDao
import com.example.data.dao.TariffDao
import com.example.data.dao.UserInfoDao
import com.example.data.migrations.Migration_1_2
import dagger.Module
import dagger.Provides

@Module(includes = [DataBindsModule::class])
class DataModule {
    @Provides
    fun provideDatabase(context: Context): Database =
        Room.databaseBuilder(context, Database::class.java, "db")
            .addMigrations(Migration_1_2).build()

    @Provides
    fun provideTariffsDao(database: Database): TariffDao = database.getTariffDao()

    @Provides
    fun provideUserDao(database: Database): UserInfoDao = database.getUserDao()

    @Provides
    fun provideBalanceDao(database: Database): BalanceDao = database.getBalanceDao()
}

