package dev.kichan.week4

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PigService {
    @GET("/1250000/othbcact/getOthbcact")
    suspend fun getSecdule(
        @Query("keyword") keyword: String,
        @Query("excman") excman: String = "",
        @Query("bgng_ymd") bgng_ymd: String,
        @Query("end_ymd") end_ymd: String,
        @Query("numOfRows") numOfRows: Int,
        @Query("pageNo") pageNo: Int,
        @Query("ServiceKey")
        ServiceKey: String = API_KEY,
    ): Response<PigRes>

    companion object {
        const val API_KEY = "G%2FtltLme%2F8XjNaoEEJAdocW8C8hrEox3bK2rKMKnmkjqbP0pAaXI0SGHvlyT6si0Gyc0gKk4US7Pmx9kEj0qbg%3D%3D"
    }
}