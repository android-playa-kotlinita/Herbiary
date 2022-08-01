package com.apk.herbiary.screens.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apk.herbiary.core.common.Result
import com.apk.herbiary.feature.authentication.R
import com.apk.herbiary.password.validator.abstraction.ConstraintConstants
import com.apk.herbiary.password.validator.model.ConstraintResult
import com.apk.herbiary.screens.login.repository.AuthenticationRepository
import com.apk.herbiary.screens.login.util.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val authenticationRepository: AuthenticationRepository,
    private val passwordValidator: PasswordValidator
) : ViewModel() {

    private val _uiState: MutableStateFlow<SignUpUiState> = MutableStateFlow(
        SignUpUiState(
            constraints = passwordValidator.validatePerChunks("").mapToConstraintView()
        )
    )
    val uiState: StateFlow<SignUpUiState> = _uiState

    private val _isLoggedIn = Channel<Boolean>()
    val isLoggedIn = _isLoggedIn.receiveAsFlow()

    fun attemptSignUp() {
        viewModelScope.launch(Dispatchers.IO) {
            val isLoginSuccess = authenticationRepository.signUpWithEmailAndPassword(
                email = uiState.value.email,
                password = uiState.value.password
            )
            when (isLoginSuccess) {
                is Result.Error -> {
                    _isLoggedIn.send(true)
                }
                Result.Loading -> {}
                is Result.Success -> {}
            }
        }
    }

    fun onEmailChanged(email: String) {
        val state = uiState.value.copy(
            email = email,
            isEmailError = !email.isValidEmail(),
        )
        _uiState.value = updateStateForEnableButton(state)
    }

    fun onPasswordChange(password: String) {
        val constraintListResult =
            passwordValidator.validatePerChunks(password).mapToConstraintView()
        val isPasswordValid = constraintListResult.all{ it.valid}
        val isConfirmationPasswordError =
            uiState.value.confirmPassword.isNotEmpty() && uiState.value.confirmPassword != password
        val state = uiState.value.copy(
            password = password,
            isPasswordError = !isPasswordValid,
            isConfirmationPasswordError = isConfirmationPasswordError,
            constraints = constraintListResult
        )
        _uiState.value = updateStateForEnableButton(state)
    }

    fun onConfirmPasswordChange(password: String) {
        val isConfirmationPasswordValid = password.isEmpty() || uiState.value.password == password
        val state = uiState.value.copy(
            confirmPassword = password,
            isConfirmationPasswordError = !isConfirmationPasswordValid,
        )
        _uiState.value = updateStateForEnableButton(state)
    }

    private fun updateStateForEnableButton(uiState: SignUpUiState): SignUpUiState {
        val areFieldsNotEmpty =
            uiState.email.isNotEmpty() && uiState.password.isNotEmpty() && uiState.confirmPassword.isNotEmpty()
        val areFieldsValid =
            !uiState.isPasswordError && !uiState.isConfirmationPasswordError && !uiState.isEmailError
        return uiState.copy(isSignUpButtonEnabled = areFieldsNotEmpty && areFieldsValid)
    }
}

val constraintStringMap = mapOf(
    ConstraintConstants.CAPITAL_LETTER_CONSTRAINT to R.string.password_capital_letter,
    ConstraintConstants.LOWER_LETTER_CONSTRAINT to R.string.password_lower_letter,
    ConstraintConstants.SPECIAL_CHARACTER_CONSTRAINT to R.string.password_special_character_constraint,
    ConstraintConstants.DIGIT_CONSTRAINT to R.string.password_digit_constraint,
    ConstraintConstants.MINIMUM_LENGTH to R.string.password_min_length,
)

fun List<ConstraintResult>.mapToConstraintView(): List<ConstraintView> = map {
    ConstraintView(
        key = it.constraint.key,
        resource = constraintStringMap[it.constraint.key] ?: 0,
        isValid = it.valid
    )
}

data class SignUpUiState(
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val isEmailError: Boolean = false,
    val isPasswordError: Boolean = false,
    val isConfirmationPasswordError: Boolean = false,
    val isSignUpButtonEnabled: Boolean = false,
    val constraints: List<ConstraintView> = emptyList()
)

data class ConstraintView(
    val key: String,
    val text: String? = null,
    val resource: Int = 0,
    val isValid: Boolean
)