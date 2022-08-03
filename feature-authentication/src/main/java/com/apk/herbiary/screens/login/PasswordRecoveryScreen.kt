package com.apk.herbiary.screens.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.apk.herbiary.core.ui.ui.AppLogo
import com.apk.herbiary.core.ui.ui.PasswordTextField
import com.apk.herbiary.feature.authentication.R

@Composable
fun PasswordRecoveryRoute(
    onBackClick: () -> Unit,
    navigateToHome: () -> Unit,
    viewModel: PasswordRecoveryViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    PasswordRecoveryScreen(
        onBackClick = onBackClick,
        uiState = uiState,
        navigateStatus = false,
        navigateToHome = navigateToHome,
        onPasswordResetClick = viewModel::resetPassword,
        onPasswordChange = viewModel::onPasswordChange,
        onConfirmPasswordChange = viewModel::onConfirmPasswordChange,
    )
}

@Composable
fun PasswordRecoveryScreen(
    onBackClick: () -> Unit,
    uiState: PasswordRecoveryUiState,
    navigateStatus: Boolean,
    navigateToHome: () -> Unit,
    onPasswordResetClick: () -> Unit,
    onPasswordChange: (String) -> Unit,
    onConfirmPasswordChange: (String) -> Unit
) {
    if (navigateStatus)
        navigateToHome()
    Surface {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(24.dp))
            AppLogo()
            Spacer(modifier = Modifier.height(64.dp))

            Text(
                stringResource(id = R.string.password_change),
                style = MaterialTheme.typography.h3,
                modifier = Modifier.align(Alignment.Start)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                stringResource(id = R.string.password_reset_description),
                fontSize = 14.sp,
                modifier = Modifier.align(Alignment.Start)
            )

            PasswordTextField(
                password = uiState.password,
                onTextChange = { onPasswordChange(it) },
                labelText = stringResource(id = R.string.password),
                hasError = uiState.isPasswordError,
                contentDescription = stringResource(id = R.string.password_visibility),
                errorMessage = stringResource(id = R.string.invalid_password_format)
            )

            Spacer(modifier = Modifier.height(12.dp))

            PasswordTextField(
                password = uiState.confirmPassword,
                onTextChange = { onConfirmPasswordChange(it) },
                labelText = stringResource(id = R.string.confirm_password),
                hasError = uiState.isConfirmationPasswordError,
                errorMessage = stringResource(id = R.string.passwords_doesnt_match),
                contentDescription = stringResource(id = R.string.confirmation_password_visibility)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = onPasswordResetClick,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.green),
                    contentColor = colorResource(id = R.color.white)
                ),
                contentPadding = PaddingValues(vertical = 12.dp, horizontal = 12.dp),
                enabled = uiState.isConfirmButtonEnabled,
                shape = MaterialTheme.shapes.large
            ) {
                Text(
                    stringResource(id = R.string.reset_password),
                    style = MaterialTheme.typography.body2
                )
            }

        }
    }
}

@Preview
@Composable
fun PasswordRecoveryPreview() {
    PasswordRecoveryScreen(onBackClick = {},
        uiState = PasswordRecoveryUiState(),
        navigateStatus = false,
        navigateToHome = {},
        onPasswordResetClick = {},
        onPasswordChange = {},
        onConfirmPasswordChange = {})
}