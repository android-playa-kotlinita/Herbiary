package com.apk.herbiary.screens.login.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.apk.herbiary.feature.authentication.R

@Composable
fun GoogleSignInButton(onClick: () -> Unit){
    OutlinedButton(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(28.dp)
    ) {
        Icon(
            painterResource(id = R.drawable.ic_google), contentDescription = stringResource(
                id = R.string.sign_in_with_google
            ), tint = Color.Unspecified
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(stringResource(R.string.sign_in_with_google), color = Color.Black)
    }
}

@Preview
@Composable
fun GoogleSignInButtonPreview(){
    GoogleSignInButton {

    }
}