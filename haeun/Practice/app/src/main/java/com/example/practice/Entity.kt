package com.example.practice

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "User")
data class UserEntity (
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    val name: String,
    val age: String,
    val gender: String?,
    // class의 필드 이름이 테이블의 속성 이름이지만 다른 이름 사용할 경우
    @ColumnInfo(name = "phone_number") val phoneNumber: String
)