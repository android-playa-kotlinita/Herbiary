package com.apk.herbiary.screens.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apk.herbiary.core.common.Result
import com.apk.herbiary.password.validator.abstraction.Constraint
import com.apk.herbiary.password.validator.abstraction.MinimumLength
import com.apk.herbiary.password.validator.abstraction.PasswordValidator
import com.apk.herbiary.screens.login.repository.AuthenticationRepository
import com.apk.herbiary.screens.login.util.isValidEmail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val authenticationRepository: AuthenticationRepository,
    private val passwordValidator: PasswordValidator
) : ViewModel() {

    private val _uiState: MutableStateFlow<SignInUiState> = MutableStateFlow(SignInUiState())
    val uiState: StateFlow<SignInUiState> = _uiState

    private val hasLoggedIn = Channel<Boolean>()
    val hasLoggedInFlow = hasLoggedIn.receiveAsFlow()

    fun attemptLogin() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = authenticationRepository.attemptLogin(
                email = uiState.value.email,
                password = uiState.value.password
            )
            when(result){
                is Result.Success -> {
                    hasLoggedIn.send(true)
                }
                is Result.Error -> {}
                is Result.Loading -> {}
            }
        }
    }

    fun onEmailChanged(email: String) {
        _uiState.value = _uiState.value.copy(
            email = email,
            isEmailError = !email.isValidEmail()
        )
    }

    fun onPasswordChange(password: String) {
        val isPasswordValid = !passwordValidator.validate(password)
        _uiState.value = _uiState.value.copy(
            password = password,
            isPasswordError = !isPasswordValid,
            isSignInButtonEnabled = !_uiState.value.isEmailError && !isPasswordValid
        )
    }
}

data class SignInUiState(
    val email: String = "",
    val password: String = "",
    val isEmailError: Boolean = false,
    val isPasswordError: Boolean = false,
    val isSignInButtonEnabled: Boolean = false,
)