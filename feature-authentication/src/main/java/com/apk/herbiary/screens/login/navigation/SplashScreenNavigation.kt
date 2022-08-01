package com.apk.herbiary.screens.login.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.apk.herbiary.core.common.NavigationDestination
import com.apk.herbiary.screens.login.SplashRoute

object SplashDestination : NavigationDestination {
    override val route = "splash_route"
    override val destination = "splash_destination"
}

fun NavGraphBuilder.splashGraph(
    navigateToSignIn: () -> Unit,
    navigateToHome: () -> Unit,
) {
    composable(route = SplashDestination.route) {
        SplashRoute(
            navigateToSignIn = navigateToSignIn,
            navigateToHome = navigateToHome
        )
    }
}