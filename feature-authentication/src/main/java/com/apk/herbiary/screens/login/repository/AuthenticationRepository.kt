package com.apk.herbiary.screens.login.repository

import com.apk.herbiary.core.model.data.User
import com.apk.herbiary.core.common.Result

interface AuthenticationRepository {
    suspend fun attemptLogin(email: String, password: String): Result<User>
    suspend fun signUpWithEmailAndPassword(email: String, password: String): Result<User>
    suspend fun requestPasswordReset(email: String)
}