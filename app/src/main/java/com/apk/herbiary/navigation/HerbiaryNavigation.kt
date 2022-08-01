package com.apk.herbiary.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.apk.herbiary.garden.navigation.GardenDestination
import com.apk.herbiary.garden.navigation.gardenGraph
import com.apk.herbiary.screens.login.navigation.ForgotPasswordNavigation
import com.apk.herbiary.screens.login.navigation.SignInDestination
import com.apk.herbiary.screens.login.navigation.SignUpNavigation
import com.apk.herbiary.screens.login.navigation.SplashDestination
import com.apk.herbiary.screens.login.navigation.forgotPasswordGraph
import com.apk.herbiary.screens.login.navigation.passwordRecoveryGraph
import com.apk.herbiary.screens.login.navigation.signInGraph
import com.apk.herbiary.screens.login.navigation.signUpGraph
import com.apk.herbiary.screens.login.navigation.splashGraph

@ExperimentalComposeUiApi
@Composable
fun HerbiaryNavigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = SplashDestination.route) {
        splashGraph(
            navigateToSignIn = { navController.navigate(SignInDestination.route) },
            navigateToHome = { navController.navigate(GardenDestination.route) },
        )
        signInGraph(
            navigateToSignUp = {
                navController.navigate(SignUpNavigation.route)
            },
            navigateToPasswordRecovery = {
                navController.navigate(ForgotPasswordNavigation.route)
            },
            navigateToHome = {
                navController.navigate(GardenDestination.route)
            }
        ) {
            signUpGraph(
                onBackClick = { navController.popBackStack() },
                navigateToSignIn = { navController.popBackStack() },
                navigateToHome = { navController.navigate(GardenDestination.route) }
            )
            forgotPasswordGraph { navController.popBackStack() }
            passwordRecoveryGraph(onBackClick = { navController.popBackStack() },
                navigateToHome = { navController.navigate(GardenDestination.route) }
            )
        }
        gardenGraph()
    }
}