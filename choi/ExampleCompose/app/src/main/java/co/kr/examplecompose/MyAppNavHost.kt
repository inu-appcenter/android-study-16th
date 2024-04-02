package co.kr.examplecompose

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MyAppNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AllUI.BasicCompose.name
    ) {
        composable(AllUI.BasicCompose.name) {
            BasicCompose(
                navController = navController
            )
        }

        composable(AllUI.ScreenOneEx.name) {
            ScreenOne(
                navController = navController
            )
        }

        composable(AllUI.ScreenTwoEx.name) {
            ScreenTwo(
                navController = navController
            )
        }
    }
}