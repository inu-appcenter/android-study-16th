package com.example.example_ui_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.example_ui_compose.ui.theme.Example_UI_ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val oneViewModel = ViewModelProvider(
                this,
            )[OneViewModel::class.java]
            val twoViewModel = ViewModelProvider(
                this,
            )[TwoViewModel::class.java]
            val navController: NavHostController = rememberNavController()

            val navigationActions = remember(navController) {
                AppNavigationActions(navController)
            }

            Example_UI_ComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    SetUpNavGraph(appNavigationActions = navigationActions, navController = navController, oneViewModel = oneViewModel, twoViewModel = twoViewModel)
                }
            }
        }
    }
}

