package com.hamza.patronus.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hamza.patronus.features.splash.SplashScreen


@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = FeatureNavItem.Splash.route
    ) {

        composable(route = FeatureNavItem.Splash.route) {
            SplashScreen(navController = navController)
        }

//        composable(route = FeatureNavItem.DeviceHolderListing.route) {
//
//            // TODO: add device holder screen
//
//        }
//
//
//        composable(route = FeatureNavItem.Splash.route) {
//            // todo add device holder details screen route
//
//         }

    }
}


sealed class FeatureNavItem(val route: String) {
    object Splash : FeatureNavItem("splash_screen")
    object DeviceHolderListing : FeatureNavItem("deviceholder_listing_screen")
    object DeviceHolderDetails : FeatureNavItem("deviceholder_details_screen/{userID}")
}