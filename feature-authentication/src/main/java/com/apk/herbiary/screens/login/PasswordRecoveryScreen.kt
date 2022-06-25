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
import java.time.temporal.TemporalAdjusters.next

@Composable
fun PasswordRecoveryScreen(navController: NavHostController) {
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
                fontSize = 24.sp,
                modifier = Modifier.align(Alignment.Start)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                stringResource(id = R.string.password_reset_description),
                fontSize = 14.sp,
                modifier = Modifier.align(Alignment.Start)
            )

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
                    stringResource(id = R.string.reset_password),
                    fontSize = 14.sp
                )
            }

        }
    }
}

@Preview
@Composable
fun PasswordRecoveryPreview() {
    PasswordRecoveryScreen(navController = rememberNavController())
}