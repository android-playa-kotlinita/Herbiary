package com.apk.herbiary.garden

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.apk.herbiary.core.ui.ui.AppLogo

@Composable
fun GardenRoute(){
    GardenScreen()
}

@Composable
fun GardenScreen(){
    Surface {
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
            AppLogo()
        }
    }
}