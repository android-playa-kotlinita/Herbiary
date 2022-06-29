package com.apk.herbiary.screens.login.repository

import javax.inject.Inject

class FakeLoginRepository @Inject constructor() : LoginRepository {
    override suspend fun attemptLogin(): Boolean {
        return true
    }
}