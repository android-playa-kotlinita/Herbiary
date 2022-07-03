package com.apk.herbiary.screens.login.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.apk.herbiary.core.ui.theme.Green500

@Composable
fun NonBackgroundTextButton(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = Green500,
    onClick: () -> Unit,
    contentPadding: PaddingValues = PaddingValues(2.dp)
) {
    TextButton(
        onClick = onClick,
        contentPadding = contentPadding,
        modifier = modifier
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.button,
            color = color
        )
    }
}

