package com.loogika.ysearch.core.navigation


sealed class DashboardScreens(val route: String) {
    object Dashboard : DashboardScreens("Dashboard")
    object Home : DashboardScreens("Home")
    object Tarot : DashboardScreens("Tarot")
    object Result : DashboardScreens("Result")
}