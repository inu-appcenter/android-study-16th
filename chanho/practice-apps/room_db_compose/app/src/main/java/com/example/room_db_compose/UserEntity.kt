package com.example.room_db_compose

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val userid: Int = 0,
    val name: String,
    val age: String,
    val gender: String?,
    val phoneNumber: String,
)
