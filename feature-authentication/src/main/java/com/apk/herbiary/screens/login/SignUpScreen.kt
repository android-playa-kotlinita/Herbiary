package com.apk.herbiary.screens.login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.apk.herbiary.feature.authentication.R
import com.apk.herbiary.screens.login.ui.AppLogo
import com.apk.herbiary.screens.login.ui.ConfirmationPasswordTextField
import com.apk.herbiary.screens.login.ui.PasswordTextField
import com.apk.herbiary.screens.login.ui.SignUpButton

@Composable
fun SignUpScreen(navController: NavHostController) {
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

            var text by remember { mutableStateOf("") }

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = text,
                onValueChange = { text = it },
                label = { Text(stringResource(id = R.string.username)) }
            )

            Spacer(modifier = Modifier.height(12.dp))


            var password by remember { mutableStateOf("") }
            var confirmPassword by remember { mutableStateOf("") }
            var hasError by remember { mutableStateOf(false) }
            var hasErrorConfirm by remember { mutableStateOf(false) }

            PasswordTextField(
                password = password,
                onTextChange = { password = it },
                labelText = stringResource(id = R.string.password),
                hasError = hasError
            )
            Spacer(modifier = Modifier.height(12.dp))

            ConfirmationPasswordTextField(
                password = confirmPassword,
                confirmPassword = password,
                onTextChange = { confirmPassword = it },
                labelText = stringResource(id = R.string.confirm_password),
                hasError = hasErrorConfirm
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.green),
                    contentColor = colorResource(id = R.color.white)
                ),
                contentPadding = PaddingValues(vertical = 12.dp, horizontal = 12.dp),
                shape = RoundedCornerShape(28.dp)
            ) {
                Text(
                    stringResource(id = R.string.sign_up),
                    fontSize = 14.sp
                )
            }
            OutlinedButton(
                onClick = { /*TODO*/ },
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

            TextButton(onClick = { /*TODO*/ }, contentPadding = PaddingValues(2.dp)) {
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
    SignUpScreen(navController = rememberNavController())
}