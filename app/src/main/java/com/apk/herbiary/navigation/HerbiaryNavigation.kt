package com.apk.herbiary.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.apk.herbiary.screens.login.navigation.*

@ExperimentalComposeUiApi
@Composable
fun HerbiaryNavigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = LoginDestination.route) {
        splashGraph(
            navigateToSignIn = { navController.navigate(LoginDestination.route) },
            navigateToHome = {},
        )
        loginGraph(
            navigateToSignUp = {
                navController.navigate(SignUpNavigation.route)
            },
            navigateToPasswordRecovery = {
                navController.navigate(ForgotPasswordNavigation.route)
            },
            nestedGraphs = {
                signUpGraph { navController.popBackStack() }
                forgotPasswordGraph { navController.popBackStack() }
                forgotPasswordGraph { navController.popBackStack() }
            }
        )
    }
}