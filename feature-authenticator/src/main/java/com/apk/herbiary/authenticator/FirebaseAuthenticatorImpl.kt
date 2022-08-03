package com.apk.herbiary.authenticator

import com.apk.herbiary.core.common.Result
import com.apk.herbiary.core.model.data.User
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FirebaseAuthenticatorImpl @Inject constructor() : Authenticator {

    override suspend fun signInWithEmailPassword(email: String, password: String): Result<User> {
        val signInResult = Firebase.auth.signInWithEmailAndPassword(email, password).await()
        val result = signInResult.user?.let { firebaseUser ->
            Result.Success(data = firebaseUser.mapToUser())
        } ?: Result.Error(null)
        return result
    }

    override suspend fun signUpWithEmailPassword(email: String, password: String): Result<User> {
        val signupResult = Firebase.auth.createUserWithEmailAndPassword(email, password).await()
        val result = signupResult.user?.let { firebaseUser ->
            Result.Success(data = firebaseUser.mapToUser())
        } ?: Result.Error(null)
        return result
    }

    override fun signOut() {
        Firebase.auth.signOut()
    }

    override fun getUser(): Result<User> {
        return Firebase.auth.currentUser?.let { firebaseUser ->
            Result.Success(firebaseUser.mapToUser())
        } ?: Result.Error(null)
    }

    override suspend fun sendPasswordReset(email: String): Result<Unit> {
        Firebase.auth.sendPasswordResetEmail(email).await()
        return Result.Success(Unit)
    }
}