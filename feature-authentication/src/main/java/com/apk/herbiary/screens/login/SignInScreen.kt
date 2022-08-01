package com.apk.herbiary.screens.login

import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.layout.*
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
import com.apk.herbiary.core.ui.ui.AppLogo
import com.apk.herbiary.core.ui.ui.HerbiaryOutlinedTextField
import com.apk.herbiary.screens.login.ui.GoogleSignInButton
import com.apk.herbiary.core.ui.ui.NonBackgroundTextButton
import com.apk.herbiary.core.ui.ui.PasswordTextField

@Composable
fun SignInRoute(
    navigateToSignUp: () -> Unit,
    navigateToPasswordRecovery: () -> Unit,
    navigateToHome: () -> Unit,
    viewModel: SignInViewModel = hiltViewModel()
) {
    val uiState: SignInUiState by viewModel.uiState.collectAsState()
    val navigationState: Boolean by viewModel.hasLoggedInFlow.collectAsState(initial = false)

    SignInScreen(
        navigateToSignUp = navigateToSignUp,
        navigateToPasswordRecovery = navigateToPasswordRecovery,
        signInUiState = uiState,
        navigateToHome = navigateToHome,
        onAttemptLogin = viewModel::attemptLogin,
        navigationState = navigationState,
        onPasswordChange = viewModel::onPasswordChange,
        onEmailChange = viewModel::onEmailChanged
    )
}

@VisibleForTesting
@Composable
internal fun SignInScreen(
    modifier: Modifier = Modifier,
    navigationState: Boolean,
    signInUiState: SignInUiState,
    navigateToSignUp: () -> Unit,
    navigateToPasswordRecovery: () -> Unit,
    navigateToHome: () -> Unit,
    onAttemptLogin: () -> Unit,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit
) {
    if (navigationState)
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

            HerbiaryOutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = stringResource(id = R.string.username),
                isError = signInUiState.isEmailError,
                value = signInUiState.email,
                onValueChange = { onEmailChange(it) },
                showErrorMessage = signInUiState.isEmailError,
                errorMessage = stringResource(id = R.string.error_email_input),
            )

            Spacer(modifier = Modifier.height(12.dp))

            PasswordTextField(
                password = signInUiState.password,
                onTextChange = { onPasswordChange(it) },
                labelText = stringResource(id = R.string.password),
                hasError = signInUiState.isPasswordError,
                contentDescription = stringResource(id = R.string.password_visibility),
                errorMessage = stringResource(id = R.string.invalid_password_format)
            )

            NonBackgroundTextButton(
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(2.dp),
                contentPadding = PaddingValues(2.dp),
                text = stringResource(R.string.forgot_password),
                onClick = navigateToPasswordRecovery
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { onAttemptLogin() },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.green),
                    contentColor = colorResource(id = R.color.white)
                ),
                enabled = signInUiState.isSignInButtonEnabled,
                contentPadding = PaddingValues(vertical = 12.dp, horizontal = 12.dp),
                shape = MaterialTheme.shapes.large
            ) {
                Text(
                    stringResource(id = R.string.log_in),
                    fontSize = 14.sp
                )
            }

            GoogleSignInButton(text = stringResource(R.string.sign_in_with_google)) {
                //TODO: OnClickImpl
            }

            Row(
                modifier = modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = stringResource(id = R.string.not_a_member_yet))
                NonBackgroundTextButton(
                    text = stringResource(R.string.sign_up),
                    onClick = navigateToSignUp
                )
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    SignInScreen(navigateToSignUp = {},
        navigateToPasswordRecovery = {},
        navigationState = false,
        onAttemptLogin = {},
        navigateToHome = {},
        signInUiState = SignInUiState(),
        onEmailChange = {},
        onPasswordChange = {})
}
