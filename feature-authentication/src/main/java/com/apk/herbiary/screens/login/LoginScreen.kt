package com.apk.herbiary.screens.login

import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun LoginScreen(navController: NavHostController) {
    Text(
        text = "Login Screen",
        modifier = Modifier.clickable {
            navController.popBackStack()
        }
    )
}