package com.example.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.data.models.UserInfoEntity

@Dao
interface UserInfoDao {
    @Insert
    suspend fun saveAll(vararg users: UserInfoEntity)
    @Query("select * from user")
    suspend fun getAll(): List<UserInfoEntity>
}