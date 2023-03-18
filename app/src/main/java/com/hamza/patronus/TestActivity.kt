package com.hamza.patronus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.hamza.patronus.navigation.NavGraph
import com.hamza.patronus.ui.theme.PatronusCodeChallengeTheme
import dagger.hilt.android.AndroidEntryPoint


class TestActivity : ComponentActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContent {
            PatronusCodeChallengeTheme {


                Greeting(name = "Hamza")

            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        modifier = Modifier
            .padding(16.dp)
            .drawBehind {
                drawCircle(
                    color = Color.Gray,
                    radius = this.size.maxDimension
                )
            }
            .size(80.dp),
        text = "HM",
        fontSize = 22.sp,
        fontWeight = FontWeight.ExtraBold,

    )
}

@Preview(showSystemUi = true)
@Composable
fun GreetingPreview() {
    
    Greeting("Android")
}



