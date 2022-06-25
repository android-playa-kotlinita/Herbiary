package com.apk.herbiary.screens.login.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.apk.herbiary.feature.authentication.R

@Composable
fun AppLogo(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(painter = painterResource(R.drawable.ic_vector), contentDescription = "")
        Spacer(modifier = Modifier.width(12.dp))
        Text(text = stringResource(id = R.string.app_name))
    }
}