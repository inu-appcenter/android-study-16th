package com.example.retrofit_practice_compose.model

import com.google.gson.annotations.SerializedName

data class Restaurant(
    @SerializedName("번호")
    val id: Int,
    @SerializedName("비고")
    val category: String,
    @SerializedName("세부주소")
    val detailAddress: String,
    @SerializedName("시군명")
    val address: String,
    @SerializedName("업 소 명")
    val name: String,
    @SerializedName("전화번호")
    val phone: String
)