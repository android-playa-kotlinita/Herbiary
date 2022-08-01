package com.apk.herbiary.core.ui.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HerbiaryOutlinedTextField(
    modifier: Modifier = Modifier,
    value: String = "",
    onValueChange: (String) -> Unit = {},
    isError: Boolean = false,
    showErrorMessage: Boolean = false,
    errorMessage: String = "",
    label: String = "",
    errorMessageStyle: TextStyle = MaterialTheme.typography.body2,
    inputStyle: TextStyle = MaterialTheme.typography.body1
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            modifier = modifier,
            value = value,
            onValueChange = onValueChange,
            label = { Text(text = label) },
            isError = isError,
            textStyle = inputStyle
        )
        if (showErrorMessage) {
            Text(
                text = errorMessage,
                style = errorMessageStyle
            )
        }
    }
}

@Preview
@Composable
fun OutlinedTextFieldPreview(){
    HerbiaryOutlinedTextField(
        showErrorMessage = true,
        errorMessage = "Test",
        label = "Test label",
        isError = true,
        value = "Test Input"
    )
}