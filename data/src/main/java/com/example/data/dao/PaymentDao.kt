package com.example.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.data.models.PaymentEntity

@Dao
interface PaymentDao {
    @Query("Select * from paymententity")
    fun getAll(): List<PaymentEntity>

    @Insert
    fun addAll(vararg payments: PaymentEntity)

    @Delete
    fun delete(paymentEntity: PaymentEntity)
}