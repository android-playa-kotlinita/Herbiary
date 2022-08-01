package com.apk.herbiary.screens.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
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
import com.apk.herbiary.feature.authentication.R

@Composable
fun ForgotPasswordRoute(
    onBackClick: () -> Unit,
    viewModel: ForgotPasswordViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    ForgotPasswordScreen(
        onBackClick = onBackClick,
        forgotPasswordUiState = uiState,
        onPasswordResetRequest = viewModel::sendPasswordReset,
        onEmailChange = viewModel::onEmailChanged,
    )
}

@Composable
fun ForgotPasswordScreen(
    forgotPasswordUiState: ForgotPasswordUiState,
    onBackClick: () -> Unit,
    onPasswordResetRequest: () -> Unit,
    onEmailChange: (String) -> Unit,
) {
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
                stringResource(id = R.string.recover_password_title),
                fontSize = 24.sp,
                modifier = Modifier.align(Alignment.Start)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                stringResource(id = R.string.recover_password_description),
                fontSize = 14.sp,
                modifier = Modifier.align(Alignment.Start)
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = forgotPasswordUiState.email,
                onValueChange = onEmailChange,
                label = { Text(stringResource(id = R.string.username)) }
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = onPasswordResetRequest,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.green),
                    contentColor = colorResource(id = R.color.white)
                ),
                contentPadding = PaddingValues(vertical = 12.dp, horizontal = 12.dp),
                shape = RoundedCornerShape(28.dp),
                enabled = forgotPasswordUiState.isContinueButtonEnabled
            ) {
                Text(
                    stringResource(id = R.string.continue_text),
                    fontSize = 14.sp
                )
            }

        }
    }
}

@Preview
@Composable
fun ForgotPasswordPreview() {
    ForgotPasswordScreen(forgotPasswordUiState = ForgotPasswordUiState(
    ), onBackClick = {}, onPasswordResetRequest = {}, onEmailChange = {})
}