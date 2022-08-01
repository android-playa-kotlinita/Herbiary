package com.apk.herbiary.screens.login.util

import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import strikt.api.expectThat
import strikt.assertions.isFalse
import strikt.assertions.isTrue

@RunWith(RobolectricTestRunner::class)
class EmailValidatorKtTest{
    @Test
    fun given_valid_email_returns_true(){
        val target = "user@domain.com"
        val result = target.isValidEmail()
        expectThat(result).isTrue()
    }

    @Test
    fun given_invalid_email_returns_false(){
        val target = "#user@domain.com"
        val result = target.isValidEmail()
        expectThat(result).isFalse()
    }
}