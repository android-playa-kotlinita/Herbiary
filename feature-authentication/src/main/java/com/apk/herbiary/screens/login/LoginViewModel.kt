package com.apk.herbiary.screens.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apk.herbiary.screens.login.repository.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val fakeLoginRepository: LoginRepository): ViewModel() {

    private val _uiState: MutableStateFlow<LoginUiState> = MutableStateFlow(LoginUiState.Empty)
    val uiState: StateFlow<LoginUiState> = _uiState

    fun attemptLogin(email: String, password: String){
        viewModelScope.launch(Dispatchers.IO) {
            fakeLoginRepository.attemptLogin()
            _uiState.value = LoginUiState.Success("user")
        }
    }
}

sealed interface LoginUiState{
    data class Success(val userId: String): LoginUiState
    object Empty: LoginUiState
}