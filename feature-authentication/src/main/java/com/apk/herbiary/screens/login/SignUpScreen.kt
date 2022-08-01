package com.apk.herbiary.screens.login

import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
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
import com.apk.herbiary.core.ui.theme.Gray
import com.apk.herbiary.core.ui.theme.Green500
import com.apk.herbiary.core.ui.ui.AppLogo
import com.apk.herbiary.core.ui.ui.HerbiaryOutlinedTextField
import com.apk.herbiary.core.ui.ui.PasswordTextField
import com.apk.herbiary.feature.authentication.R
import com.apk.herbiary.screens.login.ui.GoogleSignInButton

@Composable
fun SignUpRoute(
    viewModel: SignUpViewModel = hiltViewModel(),
    onBackClick: () -> Unit,
    navigateToSignIn: () -> Unit,
    navigateToHome: () -> Unit,
) {
    val signUpUiState: SignUpUiState by viewModel.uiState.collectAsState()
    val navigationState: Boolean by viewModel.isLoggedIn.collectAsState(initial = false)

    SignUpScreen(
        onBackClick = onBackClick,
        signUpUiState = signUpUiState,
        navigateStatus = navigationState,
        navigateToSignIn = navigateToSignIn,
        navigateToHome = navigateToHome,
        onSignUpAttempt = viewModel::attemptSignUp,
        onEmailChange = viewModel::onEmailChanged,
        onPasswordChange = viewModel::onPasswordChange,
        onConfirmPasswordChange = viewModel::onConfirmPasswordChange
    )
}

@VisibleForTesting
@Composable
internal fun SignUpScreen(
    onBackClick: () -> Unit,
    signUpUiState: SignUpUiState,
    navigateStatus: Boolean,
    navigateToSignIn: () -> Unit,
    navigateToHome: () -> Unit,
    onSignUpAttempt: () -> Unit,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onConfirmPasswordChange: (String) -> Unit
) {
    if (navigateStatus) {
        navigateToHome()
    }
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

            HerbiaryOutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = signUpUiState.email,
                onValueChange = { onEmailChange(it) },
                label = stringResource(id = R.string.username),
                isError = signUpUiState.isEmailError,
                showErrorMessage = signUpUiState.isEmailError,
                errorMessage = stringResource(id = R.string.error_email_input),
            )

            Spacer(modifier = Modifier.height(12.dp))

            PasswordTextField(
                password = signUpUiState.password,
                onTextChange = { onPasswordChange(it) },
                labelText = stringResource(id = R.string.password),
                hasError = signUpUiState.isPasswordError,
                errorMessage = stringResource(id = R.string.invalid_password_format),
                contentDescription = stringResource(id = R.string.password_visibility)
            )
            Spacer(modifier = Modifier.height(12.dp))

            PasswordTextField(
                password = signUpUiState.confirmPassword,
                onTextChange = { onConfirmPasswordChange(it) },
                labelText = stringResource(id = R.string.confirm_password),
                hasError = signUpUiState.isConfirmationPasswordError,
                errorMessage = stringResource(id = R.string.passwords_doesnt_match),
                contentDescription = stringResource(id = R.string.confirmation_password_visibility)
            )

            Spacer(modifier = Modifier.height(4.dp))

            PasswordConstraints(signUpUiState.constraints)

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = onSignUpAttempt,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.green),
                    contentColor = colorResource(id = R.color.white)
                ),
                contentPadding = PaddingValues(vertical = 12.dp, horizontal = 12.dp),
                shape = MaterialTheme.shapes.large,
                enabled = signUpUiState.isSignUpButtonEnabled
            ) {
                Text(
                    stringResource(id = R.string.sign_up),
                    style = MaterialTheme.typography.button
                )
            }

            GoogleSignInButton(text = stringResource(R.string.sign_up_with_google)) {
                //TODO: OnClickImpl
            }

            TextButton(onClick = navigateToSignIn, contentPadding = PaddingValues(2.dp)) {
                Text(
                    stringResource(R.string.already_have_account),
                    fontSize = 12.sp,
                    color = colorResource(id = R.color.green)
                )
            }
        }
    }
}

@Preview
@Composable
fun DefaultSignUpPreview() {
    SignUpScreen(onBackClick = {},
        signUpUiState = SignUpUiState(),
        navigateStatus = false,
        navigateToSignIn = {},
        navigateToHome = {},
        onSignUpAttempt = {},
        onEmailChange = {},
        onPasswordChange = {},
        onConfirmPasswordChange = {})
}

@Composable
fun PasswordConstraints(constraints: List<ConstraintView>) {
    LazyColumn {
        items(constraints, key = { it.key }) { constraint ->
            PasswordConstraintText(constraint)
        }
    }
}

@Composable
fun PasswordConstraintText(constraint: ConstraintView) {
    Row(
        Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Canvas(
            modifier = Modifier
                .padding(end = 4.dp)
                .size(4.dp)
        ) {
            drawCircle(if (constraint.isValid) Green500 else Gray)
        }
        Text(
            style = MaterialTheme.typography.caption,
            text = stringResource(id = constraint.resource),
            color = if (constraint.isValid) Green500 else Gray
        )
    }
}
