package com.apk.herbiary.screens.login.util

import org.junit.Test
import strikt.api.expectThat
import strikt.assertions.isFalse
import strikt.assertions.isTrue

class StrongPasswordValidatorTest{

    private val  validator = StrongPasswordValidator()

    @Test
    fun `given a strong password should be a valid strong password`(){
        val password = "ContrasenaPato123.!"
        val result = validator.validate(password)
        expectThat(result).isTrue()
    }

    @Test
    fun `given a non-valid-length password should not be valid`(){
        val password = "Pop3.!"
        val result = validator.validate(password)
        expectThat(result).isFalse()
    }

    @Test
    fun `given an only letters password should not be valid`(){
        val password = "Popopopopopopo"
        val result = validator.validate(password)
        expectThat(result).isFalse()
    }

    @Test
    fun `given an only digits password should not be valid`(){
        val password = "0123456789"
        val result = validator.validate(password)
        expectThat(result).isFalse()
    }

    @Test
    fun `given an only non-digit-non-letter password should not be valid`(){
        val password = "!.#$1@#$$!#!%%@#%"
        val result = validator.validate(password)
        expectThat(result).isFalse()
    }

    @Test
    fun `given an only capital-letters password should not be valid`(){
        val password = "ABCDEFGHIJK"
        val result = validator.validate(password)
        expectThat(result).isFalse()
    }

    @Test
    fun `given an only low-case-letters password should not be valid`(){
        val password = "abcdefghijk"
        val result = validator.validate(password)
        expectThat(result).isFalse()
    }

}