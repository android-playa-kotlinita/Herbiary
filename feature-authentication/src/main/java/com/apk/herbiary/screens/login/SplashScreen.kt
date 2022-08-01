package com.apk.herbiary.screens.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.apk.herbiary.core.ui.ui.AppLogo
import kotlinx.coroutines.delay
import kotlin.time.ExperimentalTime


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

@OptIn(ExperimentalTime::class)
@Composable
fun SplashScreen(
    navigateToSignIn: () -> Unit,
    navigateToHome: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppLogo()
    }
    LaunchedEffect(true) {
        delay(timeMillis = 1000)
        navigateToSignIn()
    }
}

@Preview
@Composable
fun SplashScreenPreview() {
    SplashScreen(navigateToSignIn = {}, navigateToHome = {})
}