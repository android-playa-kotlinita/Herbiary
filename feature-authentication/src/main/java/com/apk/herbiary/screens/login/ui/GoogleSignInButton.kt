package com.apk.herbiary.screens.login.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.apk.herbiary.core.ui.theme.Black
import com.apk.herbiary.core.ui.theme.Shapes
import com.apk.herbiary.feature.authentication.R

@Composable
fun GoogleSignInButton(
    modifier: Modifier = Modifier,
    shape: CornerBasedShape = Shapes.large,
    style: TextStyle = MaterialTheme.typography.button,
    text: String,
    accessibility: String = text,
    onClick: () -> Unit,
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth(),
        shape = shape
    ) {
        Icon(
            painterResource(id = R.drawable.ic_google),
            contentDescription = accessibility,
            tint = Color.Unspecified
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = text,
            style = style,
            color = Black
        )
    }
}

@Preview
@Composable
fun GoogleSignInButtonPreview() {
    GoogleSignInButton(text = "") {

    }
}