package com.example.retrofit_practice_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.retrofit_practice_compose.ui.theme.Retrofit_practice_composeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Retrofit_practice_composeTheme {
                // A surface container using the 'background' color from the theme
                val goodRestaurantViewModel = ViewModelProvider(this)[GoodRestaurantViewModel::class.java]

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GoodRestaurantScreen(goodRestaurantViewModel = goodRestaurantViewModel)

                }
            }
        }
    }
}

