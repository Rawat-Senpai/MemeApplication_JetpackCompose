package com.example.memeapplication_jetpackcompose.navgraph

sealed class Route(
    val route:String
) {

    object OnBoardingScreen: Route(route = "onBoardingScreen")

    object HomeScreen:Route(route = "homeScreen")

    object AppStarNavigation:Route(route = "appStartNavigation")
}
