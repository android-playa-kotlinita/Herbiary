package com.apk.herbiary.screens.login.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.apk.herbiary.core.common.NavigationDestination
import com.apk.herbiary.screens.login.LoginRoute

object LoginDestination : NavigationDestination {
    override val route = "login_route"
    override val destination = "login_destination"
}

fun NavGraphBuilder.loginGraph(
    navigateToSignUp: () -> Unit,
    navigateToPasswordRecovery: () -> Unit,
    nestedGraphs: NavGraphBuilder.() -> Unit
) {
    navigation(
        route = LoginDestination.route,
        startDestination = LoginDestination.destination
    ) {
        composable(route = LoginDestination.destination) {
            LoginRoute(
                navigateToSignUp = navigateToSignUp,
                navigateToPasswordRecovery = navigateToPasswordRecovery,
                navigateToHome = {}
            )
        }
        nestedGraphs()
    }
}