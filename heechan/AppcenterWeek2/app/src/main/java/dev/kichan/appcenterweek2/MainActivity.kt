package dev.kichan.appcenterweek2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.kichan.appcenterweek2.ui.Screen
import dev.kichan.appcenterweek2.ui.theme.AppcenterWeek2Theme
import dev.kichan.appcenterweek2.ui.theme.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppcenterWeek2Theme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = Screen.Main.name) {
                    composable(Screen.Main.name) {
                        MainScreen(navController)
                    }
                    composable(Screen.One.name) {
                        OneScreen(navController)
                    }
                    composable(Screen.Two.name) {
                        TwoScreen(navController)
                    }
                }
            }
        }
    }
}