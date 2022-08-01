package com.apk.herbiary.screens.login.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.apk.herbiary.core.common.NavigationDestination
import com.apk.herbiary.screens.login.SignInRoute

object SignInDestination : NavigationDestination {
    override val route = "login_route"
    override val destination = "login_destination"
}

fun NavGraphBuilder.signInGraph(
    navigateToSignUp: () -> Unit,
    navigateToPasswordRecovery: () -> Unit,
    navigateToHome: () -> Unit,
    nestedGraphs: NavGraphBuilder.() -> Unit
) {
    navigation(
        route = SignInDestination.route,
        startDestination = SignInDestination.destination
    ) {
        composable(route = SignInDestination.destination) {
            SignInRoute(
                navigateToSignUp = navigateToSignUp,
                navigateToPasswordRecovery = navigateToPasswordRecovery,
                navigateToHome = navigateToHome
            )
        }
        nestedGraphs()
    }
}