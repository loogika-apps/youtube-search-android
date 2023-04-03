package com.loogika.ysearch.search

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.ModalBottomSheetLayout
import com.google.accompanist.navigation.material.rememberBottomSheetNavigator
import com.loogika.ysearch.core.navigation.Screens
import com.loogika.ysearch.search.screen.SearchScreen
import com.loogika.ysearch.uikit.style.YSearchTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchActivity : ComponentActivity() {
    private var startDestination = Screens.SearchScreen.route
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            YSearchTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background,
                    modifier = Modifier.fillMaxSize()
                ) {
                    SearchApp()
                }
            }
        }
    }

    @OptIn(ExperimentalAnimationApi::class, ExperimentalMaterialNavigationApi::class)
    @Composable
    fun SearchApp() {
        val bottomSheetNavigator = rememberBottomSheetNavigator()
        val navController = rememberAnimatedNavController(bottomSheetNavigator)

        ModalBottomSheetLayout(bottomSheetNavigator) {
            AnimatedNavHost(
                navController = navController,
                startDestination = startDestination
            ) {
                composable(Screens.SearchScreen.route) {
                    SearchScreen(
                        onNavigateToScreen = {

                        }
                    )
                }
            }
        }
    }
}
