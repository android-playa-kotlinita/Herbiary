package com.apk.herbiary.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.apk.herbiary.screens.login.LoginScreen
import com.apk.herbiary.screens.splash.SplashScreen

@ExperimentalComposeUiApi
@Composable
fun HerbiaryNavigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = HerbiaryScreens.SplashScreen.name){
        composable(HerbiaryScreens.SplashScreen.name){
            SplashScreen(navController= navController)
        }

        composable(HerbiaryScreens.LoginScreen.name){
            LoginScreen(navController = navController)
        }
    }
}