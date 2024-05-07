package com.example.retrofit_practice_compose

import com.example.retrofit_practice_compose.model.GoodRestaurant
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GoodRestaurantRepo {
    companion object {
        private const val AUTH_KEY = "5Tw4gPbww2dQMFhoVXyQoDIB4Cr1pH1ESs4wUW6yvH2cce6EqVxaZ2nZyR7pzP1ctxWQKBUuCulkq2sMkvJBQg=="
    }

    @GET("/api/15056470/v1/uddi:d9cab793-e537-442d-a3ab-ad087f3479c3")
    suspend fun getGoodRestaurants(
        @Query("serviceKey") serviceKey : String = AUTH_KEY,
        @Query("page") page : Int = 1,
        @Query("perPage") perPage : Int = 10
    ): Response<GoodRestaurant>
}