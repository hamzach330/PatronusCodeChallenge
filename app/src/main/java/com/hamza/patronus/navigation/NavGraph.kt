package com.hamza.patronus.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.hamza.patronus.features.deviceholder_details.presentation.DeviceHolderDetailScreen
import com.hamza.patronus.features.deviceholder_listing.presentation.DeviceHolderListingScreen
import com.hamza.patronus.features.splash.SplashScreen


@Composable
fun setupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.Splash.route
    ) {

        composable(route = Screens.Splash.route) {
            SplashScreen(navController = navController)
        }

        composable(route = Screens.DeviceHolderListing.route) {
            DeviceHolderListingScreen(navController = navController)
        }

        composable(
            route = Screens.DeviceHolderDetail.route,
            arguments = listOf(navArgument("userId") { type = NavType.StringType })
        ) {
            val userId = it.arguments?.getString("userId") ?: ""
            DeviceHolderDetailScreen(navController = navController, userId = userId)
        }


    }
}


sealed class Screens(val route: String) {
    object Splash : Screens("splash_screen")
    object DeviceHolderListing : Screens("deviceholder_listing_screen")
    object DeviceHolderDetail : Screens("deviceholder_detail_screen/{userId}")
}