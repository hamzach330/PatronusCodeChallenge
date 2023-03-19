package com.hamza.patronus

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.hamza.patronus.di.AppModule
import com.hamza.patronus.features.deviceholder_details.di.DeviceHolderDetailModule
import com.hamza.patronus.features.deviceholder_details.presentation.DeviceHolderDetailScreen
import com.hamza.patronus.features.deviceholder_listing.di.DeviceHolderListingModule
import com.hamza.patronus.features.deviceholder_listing.presentation.DeviceHolderListingScreen
import com.hamza.patronus.navigation.Screens
import com.hamza.patronus.ui.theme.PatronusCodeChallengeTheme
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
@UninstallModules(
    AppModule::class,
    DeviceHolderListingModule::class,
    DeviceHolderDetailModule::class
)
class PatronusEndToEndTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setUp() {
        hiltRule.inject()
        composeRule.setContent {
            val navController = rememberNavController()
            PatronusCodeChallengeTheme {
                NavHost(
                    navController = navController,
                    startDestination = Screens.DeviceHolderListing.route
                ) {
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
        }
    }

    @Test
    fun loadUserData_navigateToDetails() {
//        composeRule.onNodeWithTag(TestTags.USERS_LISTING).assertIsDisplayed()
//        composeRule.onAllNodesWithTag(TestTags.USER_ITEM).assertAll(hasClickAction())
//        composeRule.onAllNodesWithTag(TestTags.USER_ITEM).assertCountEquals(4)
//
//        composeRule.onNodeWithText("mojombo", ignoreCase = true).assertIsDisplayed()
//
//        composeRule.onNodeWithText("mojombo", ignoreCase = true).performClick()
//
//        //check if login is shown in User Details screen
//        composeRule.onNodeWithText("Test Name", ignoreCase = true).assertIsDisplayed()


    }

}