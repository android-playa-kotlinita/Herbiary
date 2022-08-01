package com.apk.herbiary.password.validator.abstraction

import com.apk.herbiary.password.validator.model.ConstraintResult

interface PasswordValidator {
    fun validate(password: String): Boolean
    fun validatePerChunks(password: String): List<ConstraintResult>
}
