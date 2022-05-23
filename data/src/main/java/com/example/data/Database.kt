package com.example.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.AutoMigrationSpec
import com.example.data.dao.BalanceDao
import com.example.data.dao.PaymentDao
import com.example.data.dao.TariffDao
import com.example.data.dao.UserInfoDao
import com.example.data.models.BalanceEntity
import com.example.data.models.PaymentEntity
import com.example.data.models.TariffEntity
import com.example.data.models.UserInfoEntity

@Database(
    entities = [
        TariffEntity::class,
        BalanceEntity::class,
        UserInfoEntity::class,
        PaymentEntity::class,
    ],
    version = 2,
)
abstract class Database: RoomDatabase() {
    abstract fun getUserDao(): UserInfoDao
    abstract fun getTariffDao(): TariffDao
    abstract fun getBalanceDao(): BalanceDao
    abstract fun getPaymentDao(): PaymentDao
}