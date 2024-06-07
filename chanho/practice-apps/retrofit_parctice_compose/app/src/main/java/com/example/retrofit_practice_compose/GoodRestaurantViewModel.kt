package com.example.retrofit_practice_compose

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit_practice_compose.model.GoodRestaurant
import com.example.retrofit_practice_compose.model.Restaurant
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GoodRestaurantViewModel: ViewModel() {
    val tsListService = RetrofitBuilderGoodRestaurant.apiService
    // val tsListService: TourSpotDJ = RetrofitBuilderTourSpot.getInstanceFor().create()

    private val _goodRestaurants = MutableStateFlow<List<Restaurant>?>(null)
    val goodRestaurants = _goodRestaurants.asStateFlow()

    init {
//        getGoodRestaurants()
    }
    fun getGoodRestaurants(){
        viewModelScope.launch {
            try {
                val response = tsListService.getGoodRestaurants()

                if (response.isSuccessful){
                    val userInfo = response.body() ?: throw Exception("레스토랑 정보가 비어있습니다.")
                    _goodRestaurants.update {
                        userInfo.data
                    }

                } else {
                    val errorBody = response.errorBody()?.string() ?: "알 수 없는 에러 발생"
                    throw Exception("레스토랑 불러오기 실패: $errorBody")
                }

            } catch (e: Exception){
                Log.e("failed to get Restaurants", e.message.toString())
            }



        }
    }

}