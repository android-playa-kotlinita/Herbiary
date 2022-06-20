package com.apk.herbiary.screens.splash

import android.window.SplashScreen
import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.apk.herbiary.navigation.HerbiaryScreens

@Composable
fun SplashScreen(navController: NavHostController) {
    Text(
        text = "Splash Screen",
        modifier = Modifier.clickable { navController.navigate(HerbiaryScreens.LoginScreen.name) }
    )
}