package com.apk.herbiary.screens.login.repository

import com.apk.herbiary.core.common.Result
import com.apk.herbiary.core.model.data.User
import java.util.*

class FakeAuthenticationRepository : AuthenticationRepository {

    private val userList = mutableMapOf("test@test.com" to "password")

    override suspend fun attemptLogin(email: String, password: String): Result<User> {
        val existsUser = userList[email].equals(password)

        return if(existsUser) Result.Success(User(id = UUID.randomUUID().toString(),email = email)) else Result.Error()
    }

    override suspend fun signUpWithEmailAndPassword(email: String, password: String): Result<User> {
        userList[email] = password
        return Result.Success(User(UUID.randomUUID().toString(), email))
    }

    override suspend fun requestPasswordReset(email: String) {
    }

}