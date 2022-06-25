package com.apk.herbiary.screens.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.apk.herbiary.screens.login.ui.AppLogo

@Composable
fun SplashScreen(navController: NavController){
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
        AppLogo()
    }
}

@Preview
@Composable
fun SplashScreenPreview(){
    SplashScreen(navController = rememberNavController())
}