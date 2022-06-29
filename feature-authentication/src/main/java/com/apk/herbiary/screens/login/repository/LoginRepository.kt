package com.apk.herbiary.screens.login.repository

interface LoginRepository {
    suspend fun attemptLogin(): Boolean
}