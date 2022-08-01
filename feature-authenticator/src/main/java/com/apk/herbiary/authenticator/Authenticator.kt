package com.apk.herbiary.authenticator

import com.apk.herbiary.core.common.Result
import com.apk.herbiary.core.model.data.User

/**
 * Authenticator layer. Provides a layer of indirection to decouple the authentication implementation
 * i.e FirebaseAuthentication or REST API authentication.
 */
interface Authenticator {

    suspend fun signInWithEmailPassword(email:String , password:String): Result<User>

    suspend fun signUpWithEmailPassword(email:String , password:String): Result<User>

    fun signOut()

    fun getUser(): Result<User>

    suspend fun sendPasswordReset(email :String): Result<Unit>

}