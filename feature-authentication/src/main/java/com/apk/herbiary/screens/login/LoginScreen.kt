package com.apk.herbiary.screens.login

import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.apk.herbiary.feature.authentication.R
import com.apk.herbiary.screens.login.ui.AppLogo
import com.apk.herbiary.screens.login.ui.GoogleSignInButton
import com.apk.herbiary.screens.login.ui.PasswordTextField
import com.apk.herbiary.screens.login.ui.SignUpButton

@Composable
fun LoginRoute(
    modifier: Modifier = Modifier,
    navigateToSignUp: () -> Unit,
    navigateToPasswordRecovery: () -> Unit,
    navigateToHome: () -> Unit,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val uiState: LoginUiState by viewModel.uiState.collectAsState()
    LoginScreen(
        navigateToSignUp = navigateToSignUp,
        navigateToPasswordRecovery = navigateToPasswordRecovery,
        loginScreenUiState = uiState,
        navigateToHome = navigateToHome,
        onAttemptLogin = viewModel::attemptLogin
    )
}

@VisibleForTesting
@Composable
internal fun LoginScreen(
    modifier: Modifier = Modifier,
    navigateToSignUp: () -> Unit,
    navigateToPasswordRecovery: () -> Unit,
    navigateToHome: () -> Unit,
    loginScreenUiState: LoginUiState,
    onAttemptLogin: (email: String, password: String) -> Unit
) {
    if (loginScreenUiState is LoginUiState.Success)
        navigateToHome()

    Surface {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(24.dp))
            AppLogo()
            Spacer(modifier = Modifier.height(64.dp))

            var email by remember { mutableStateOf("") }

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = email,
                onValueChange = { email = it },
                label = { Text(stringResource(id = R.string.username)) }
            )

            Spacer(modifier = Modifier.height(12.dp))


            var password by remember { mutableStateOf("") }
            var hasError by remember { mutableStateOf(false) }

            PasswordTextField(
                password = password,
                onTextChange = { password = it },
                labelText = stringResource(id = R.string.password),
                hasError = hasError
            )

            TextButton(
                onClick = navigateToPasswordRecovery,
                contentPadding = PaddingValues(2.dp),
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(2.dp)
            ) {
                Text(
                    stringResource(R.string.forgot_password),
                    fontSize = 12.sp,
                    color = colorResource(id = R.color.green)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { onAttemptLogin(email, password) },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.green),
                    contentColor = colorResource(id = R.color.white)
                ),
                contentPadding = PaddingValues(vertical = 12.dp, horizontal = 12.dp),
                shape = RoundedCornerShape(28.dp)
            ) {
                Text(
                    stringResource(id = R.string.log_in),
                    fontSize = 14.sp
                )
            }
            GoogleSignInButton {
                //TODO: OnClickImpl
            }

            SignUpButton(onClick = navigateToSignUp)
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    LoginScreen(navigateToSignUp = {},
        navigateToPasswordRecovery = {},
        loginScreenUiState = LoginUiState.Empty,
        onAttemptLogin = { _: String, _: String -> },
        navigateToHome = {})
}
