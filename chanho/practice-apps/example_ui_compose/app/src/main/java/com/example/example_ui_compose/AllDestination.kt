package com.example.example_ui_compose

import androidx.navigation.NavController
import com.example.example_ui_compose.AllDestinations.MAINSCREEN
import com.example.example_ui_compose.AllDestinations.ONESCREEN
import com.example.example_ui_compose.AllDestinations.TWOSCREEN


object AllDestinations{
    const val MAINSCREEN = "MainScreen"
    const val ONESCREEN = "OneScreen"
    const val TWOSCREEN = "TwoScreen"
}

class AppNavigationActions(private val navController: NavController) {

    fun navigateToMainScreen(){
        navController.navigate(MAINSCREEN){
            popUpTo(MAINSCREEN)
        }
    }
    fun navigateToOneScreen(){
        navController.navigate(ONESCREEN){
            launchSingleTop = true
            restoreState = true
        }

    }

    fun navigateToTwoScreen(){
        navController.navigate(TWOSCREEN){
            launchSingleTop = true
            restoreState = true
        }

    }
}