package com.example.memeapplication_jetpackcompose.navgraph

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController

@Composable
fun  NavGraph(
    startDestination:String
) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination ){
        navigation(
            route= Route.AppStarNavigation.route,
            startDestination = Route.OnBoardingScreen.route
        ){
            composable(
                route= Route.OnBoardingScreen.route
            ){

            }
        }
    }

}