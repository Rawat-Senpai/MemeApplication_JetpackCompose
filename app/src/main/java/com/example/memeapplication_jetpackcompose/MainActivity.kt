package com.example.memeapplication_jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.memeapplication_jetpackcompose.models.MemeApiDataClass
import com.example.memeapplication_jetpackcompose.ui.homePackage.HomeScreen
import com.example.memeapplication_jetpackcompose.ui.homePackage.MemeViewModel

import com.example.memeapplication_jetpackcompose.ui.theme.MemeApplication_jetpackcomposeTheme
import com.example.memeapplication_jetpackcompose.utils.NetworkResult
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        WindowCompat.setDecorFitsSystemWindows(window, false)
        installSplashScreen().apply {

        }


        setContent {
            MemeApplication_jetpackcomposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }


}

@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "meme") {

        composable(route = "tutorial") {
            TutorialScreens()
        }
        composable(route = "meme") {
            HomeScreen()

        }

    }


}


@Composable
fun TutorialScreens() {
    Text(
        text = "Tutorial Screens",
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
    )
}



