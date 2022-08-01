package com.apk.herbiary.screens.login.util

import android.util.Patterns

fun String?.isValidEmail(): Boolean = Patterns.EMAIL_ADDRESS.matcher(this ?: "").matches()