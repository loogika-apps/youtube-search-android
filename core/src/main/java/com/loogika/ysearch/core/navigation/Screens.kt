package com.loogika.ysearch.core.navigation

sealed class Screens(val route: String) {
    object DashboardScreen : Screens("DashboardScreen") {
        const val ROUTE = "route"
        const val DEEPLINK = "deeplink"
    }
    object SplashScreen : Screens("SplashScreen") {
        const val START_DESTINATION = "startDestination"
    }
    object SearchScreen : Screens("SearchScreen")
}