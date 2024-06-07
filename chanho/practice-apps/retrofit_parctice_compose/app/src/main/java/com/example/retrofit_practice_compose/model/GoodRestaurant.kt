package com.example.retrofit_practice_compose.model

import com.google.gson.annotations.SerializedName

data class GoodRestaurant(
    @SerializedName("currentCount")
    val currentCount: Int,
    @SerializedName("data")
    val data: List<Restaurant>,
    @SerializedName("matchCount")
    val matchCount: Int,
    @SerializedName("page")
    val page: Int,
    @SerializedName("perPage")
    val perPage: Int,
    @SerializedName("totalCount")
    val totalCount: Int
)