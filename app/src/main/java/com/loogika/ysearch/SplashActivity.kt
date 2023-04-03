package com.loogika.ysearch

import android.content.Intent
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
import com.loogika.ysearch.screen.SplashScreen
import com.loogika.ysearch.search.SearchActivity
import com.loogika.ysearch.uikit.style.YSearchTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : ComponentActivity() {
    private var startDestination = Screens.SplashScreen.route
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            YSearchTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background,
                    modifier = Modifier.fillMaxSize()
                ) {
                    SplashApp()
                }
            }
        }
    }

    @OptIn(ExperimentalAnimationApi::class, ExperimentalMaterialNavigationApi::class)
    @Composable
    fun SplashApp() {
        val bottomSheetNavigator = rememberBottomSheetNavigator()
        val navController = rememberAnimatedNavController(bottomSheetNavigator)

        ModalBottomSheetLayout(bottomSheetNavigator) {
            AnimatedNavHost(
                navController = navController,
                startDestination = startDestination
            ) {
                composable(Screens.SplashScreen.route) {
                    SplashScreen(
                        onNavigateToSearch = {
                            val intent = Intent(applicationContext, SearchActivity::class.java)
                            startActivity(intent)
                            finish()
                        }
                    )
                }
            }
        }
    }
}
