package com.example.retrofit_practice_compose

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilderGoodRestaurant {
    private const val BASE_URL: String = "https://api.odcloud.kr"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService: GoodRestaurantRepo by lazy {
        retrofit.create(GoodRestaurantRepo::class.java)
    }
}