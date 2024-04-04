package com.example.example_ui_compose

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable

@Composable
fun SetUpNavGraph(
    appNavigationActions: AppNavigationActions,
    navController: NavHostController,
    oneViewModel: OneViewModel
) {
    NavHost(
        navController = navController,
        startDestination = AllDestinations.MAINSCREEN
    ) {
        composable(
            route = AllDestinations.MAINSCREEN
        ) {
            MainScreen(appNavigationActions = appNavigationActions)
        }
        composable(
            route = AllDestinations.ONESCREEN
        ) {
            OneScreen(appNavigationActions = appNavigationActions, oneViewModel = oneViewModel)
        }
        composable(
            route = AllDestinations.TWOSCREEN
        ) {
            TwoScreen(appNavigationActions = appNavigationActions)
        }
    }
} // End of setUpNavGraph