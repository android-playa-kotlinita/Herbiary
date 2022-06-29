package com.apk.herbiary.screens.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.apk.herbiary.screens.login.ui.AppLogo


@Composable
fun SplashRoute(
    navigateToSignIn: () -> Unit,
    navigateToHome: () -> Unit
) {
    SplashScreen(
        navigateToSignIn = navigateToSignIn,
        navigateToHome = navigateToHome
    )
}

@Composable
fun SplashScreen(
    navigateToSignIn: () -> Unit,
    navigateToHome: () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
        AppLogo()
    }
}

@Preview
@Composable
fun SplashScreenPreview() {
    SplashScreen(navigateToSignIn = {}, navigateToHome = {})
}