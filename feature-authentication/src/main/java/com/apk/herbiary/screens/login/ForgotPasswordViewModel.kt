package com.apk.herbiary.screens.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
class ForgotPasswordViewModel @Inject constructor(
    private val authenticationRepository: AuthenticationRepository,
) : ViewModel() {

    private val _uiState: MutableStateFlow<ForgotPasswordUiState> = MutableStateFlow(ForgotPasswordUiState())
    val uiState: StateFlow<ForgotPasswordUiState> = _uiState

    private val navigationChannel = Channel<Boolean>()
    val navigationFlow = navigationChannel.receiveAsFlow()

    fun sendPasswordReset() {
        viewModelScope.launch(Dispatchers.IO) {
            val isDone = authenticationRepository.requestPasswordReset(email = uiState.value.email,)
            navigationChannel.send(true)
        }
    }

    fun onEmailChanged(email: String) {
        _uiState.value = _uiState.value.copy(
            email = email,
            isEmailError = !email.isValidEmail()
        )
    }
}

data class ForgotPasswordUiState(
    val email: String = "",
    val isEmailError: Boolean = false,
    val isContinueButtonEnabled: Boolean = false
)