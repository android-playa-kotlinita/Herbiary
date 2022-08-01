package com.apk.herbiary.screens.login.repository

import com.apk.herbiary.core.common.Result
import com.apk.herbiary.core.model.data.User
import com.apk.herbiary.authenticator.Authenticator
import javax.inject.Inject

class AuthenticationRepositoryImpl @Inject constructor(
    private val authenticator: Authenticator
) : AuthenticationRepository {

    override suspend fun attemptLogin(email: String, password: String): Result<User> {
        return authenticator.signUpWithEmailPassword(email, password)
    }

    override suspend fun signUpWithEmailAndPassword(email: String, password: String): Result<User> {
        return authenticator.signUpWithEmailPassword(email, password)
    }

    override suspend fun requestPasswordReset(email: String) {
        authenticator.sendPasswordReset(email)
    }
}