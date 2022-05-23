package com.example.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PaymentEntity(
    @PrimaryKey val id: String,
    val sum: Double,
)
