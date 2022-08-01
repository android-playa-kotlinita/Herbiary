package com.apk.herbiary.screens.login.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.apk.herbiary.core.common.NavigationDestination
import com.apk.herbiary.screens.login.PasswordRecoveryRoute
import com.apk.herbiary.screens.login.PasswordRecoveryViewModel

object PasswordRecoveryNavigation : NavigationDestination {
    override val route = "password_recovery_route"
    override val destination = "password_recovery_destination"
}

fun NavGraphBuilder.passwordRecoveryGraph(
    onBackClick: () -> Unit,
    navigateToHome: () -> Unit,
) {
    composable(route = PasswordRecoveryNavigation.route){
        PasswordRecoveryRoute(onBackClick,
            navigateToHome = navigateToHome,
        )
    }
}