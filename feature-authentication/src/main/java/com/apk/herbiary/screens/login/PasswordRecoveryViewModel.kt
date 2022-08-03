package com.apk.herbiary.screens.login

import androidx.lifecycle.ViewModel
import com.apk.herbiary.password.validator.abstraction.PasswordValidator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class PasswordRecoveryViewModel @Inject constructor(
    private val passwordValidator: PasswordValidator
) : ViewModel() {

    private val _uiState: MutableStateFlow<PasswordRecoveryUiState> =
        MutableStateFlow(PasswordRecoveryUiState())
    val uiState: StateFlow<PasswordRecoveryUiState> = _uiState

    fun resetPassword(){
    }

    fun onPasswordChange(password: String) {
        val isPasswordValid = passwordValidator.validate(password)
        val isConfirmationPasswordError =
            uiState.value.confirmPassword.isNotEmpty() && uiState.value.confirmPassword != password
        _uiState.value = uiState.value.copy(
            password = password,
            isPasswordError = !isPasswordValid,
            isConfirmationPasswordError = isConfirmationPasswordError,
            isConfirmButtonEnabled = !isPasswordValid && !isConfirmationPasswordError
        )
    }

    fun onConfirmPasswordChange(password: String) {
        val isConfirmationPasswordValid = password.isEmpty() || uiState.value.password == password
        _uiState.value = uiState.value.copy(
            confirmPassword = password,
            isConfirmationPasswordError = !isConfirmationPasswordValid,
            isConfirmButtonEnabled = !isConfirmationPasswordValid && !uiState.value.isPasswordError
        )
    }
}

data class PasswordRecoveryUiState(
    val password: String = "",
    val confirmPassword: String = "",
    val isPasswordError: Boolean = false,
    val isConfirmationPasswordError: Boolean = false,
    val isConfirmButtonEnabled: Boolean = false
)