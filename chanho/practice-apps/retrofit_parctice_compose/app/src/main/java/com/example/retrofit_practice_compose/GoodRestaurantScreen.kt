package com.example.retrofit_practice_compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun GoodRestaurantScreen(
    goodRestaurantViewModel: GoodRestaurantViewModel
){
    val goodRestaurants by goodRestaurantViewModel.goodRestaurants.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyRow{
            goodRestaurants?.let {goodRestaurants->
                items(goodRestaurants){goodRestaurant->
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(text = goodRestaurant.name)
                        Text(text = goodRestaurant.category)
                        Text(text = goodRestaurant.phone)
                        Text(text = goodRestaurant.detailAddress)
                    }
                }
            }

        }

        Button(onClick = { goodRestaurantViewModel.getGoodRestaurants() }) {
            Text(text = "가져오기")
        }
    }

}