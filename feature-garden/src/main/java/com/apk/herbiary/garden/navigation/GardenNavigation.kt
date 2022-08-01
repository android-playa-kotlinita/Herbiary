package com.apk.herbiary.garden.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.apk.herbiary.core.common.NavigationDestination
import com.apk.herbiary.garden.GardenRoute

object GardenDestination: NavigationDestination{
    override val route: String = "garden_route"
    override val destination: String = "garden_destination"
}

fun NavGraphBuilder.gardenGraph(){
    composable(GardenDestination.route){
        GardenRoute()
    }
}