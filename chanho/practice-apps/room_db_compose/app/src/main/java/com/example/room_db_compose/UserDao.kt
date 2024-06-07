package com.example.room_db_compose

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDao {
    @Insert
    fun insertAll(vararg users: UserEntity)

    @Delete
    fun delete(user: UserEntity)

    @Query("SELECT * FROM User")
    fun getAll(): List<UserEntity>

    @Query("SELECT * FROM User WHERE userid = :userId")
    fun getUserById(userId: Int): UserEntity
}