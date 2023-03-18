package com.hamza.patronus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.hamza.patronus.navigation.setupNavGraph
import com.hamza.patronus.ui.theme.PatronusCodeChallengeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContent {
            PatronusCodeChallengeTheme {
                navController = rememberNavController()
                setupNavGraph(navController = navController)
                println(" In the main activity")
            }
        }
    }
}

