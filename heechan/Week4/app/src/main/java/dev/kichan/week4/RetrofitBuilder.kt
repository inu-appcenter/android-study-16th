package dev.kichan.week4

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitBuilder {
    private val BASE_URL: String = "https://apis.data.go.kr"

    fun getInstanceFor(): Retrofit {
        val instance = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return instance
    }
}