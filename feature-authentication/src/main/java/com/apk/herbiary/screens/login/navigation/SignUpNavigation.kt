package com.apk.herbiary.screens.login.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.apk.herbiary.core.common.NavigationDestination
import com.apk.herbiary.screens.login.SignUpRoute
import com.apk.herbiary.screens.login.SignUpViewModel

object SignUpNavigation : NavigationDestination {
    override val route = "signup_route"
    override val destination = "signup_destination"
}

fun NavGraphBuilder.signUpGraph(
    onBackClick: () -> Unit,
    navigateToSignIn: () -> Unit,
    navigateToHome: () -> Unit,
) {
    composable(route = SignUpNavigation.route) {
        SignUpRoute(
            onBackClick = onBackClick,
            navigateToSignIn = navigateToSignIn,
            navigateToHome = navigateToHome
        )
    }
}