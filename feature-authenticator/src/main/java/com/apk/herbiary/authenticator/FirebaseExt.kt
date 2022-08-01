package com.apk.herbiary.authenticator

import com.apk.herbiary.core.model.data.User
import com.google.firebase.auth.FirebaseUser

fun FirebaseUser.mapToUser(): User = User(this.uid, this.email)