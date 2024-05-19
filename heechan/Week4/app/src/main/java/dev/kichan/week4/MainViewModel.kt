package dev.kichan.week4

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    val pigService = RetrofitBuilder.getInstanceFor().create(PigService::class.java)
    val list = mutableStateListOf<PigItem>()

    fun getSecdule() {
        viewModelScope.launch {
            val response = pigService.getSecdule(
                keyword = "공연",
                excman = "",
                bgng_ymd = "20171010",
                end_ymd = "20240501",
                numOfRows = 10,
                pageNo = 1,
            )

            if(!response.isSuccessful) {
                return@launch
            }

            val body = response.body()!!

            Log.d("Result", body.items.toString())
            Log.d("Old", list.toString())
            list += body.items
        }
    }
}