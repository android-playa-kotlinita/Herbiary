package com.apk.herbiary.screens.login.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.apk.herbiary.core.common.NavigationDestination
import com.apk.herbiary.screens.login.ForgotPasswordRoute

object ForgotPasswordNavigation : NavigationDestination {
    override val route = "forgot_password_route"
    override val destination = "forgot_password_destination"
}

fun NavGraphBuilder.forgotPasswordGraph(
    onBackClick: () -> Unit,
) {
    composable(route = SignUpNavigation.route){
        ForgotPasswordRoute(onBackClick)
    }
}