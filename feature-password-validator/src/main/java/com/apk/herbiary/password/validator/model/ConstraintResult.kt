package com.apk.herbiary.password.validator.model

import com.apk.herbiary.password.validator.abstraction.Constraint

data class ConstraintResult(
    val constraint: Constraint,
    val valid: Boolean
)
