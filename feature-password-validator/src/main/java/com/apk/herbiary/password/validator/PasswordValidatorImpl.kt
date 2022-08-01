package com.apk.herbiary.password.validator

import com.apk.herbiary.password.validator.abstraction.Constraint
import com.apk.herbiary.password.validator.abstraction.CustomConstraint
import com.apk.herbiary.password.validator.abstraction.MinimumLength
import com.apk.herbiary.password.validator.abstraction.PasswordValidator
import com.apk.herbiary.password.validator.abstraction.RegexConstraint
import com.apk.herbiary.password.validator.model.ConstraintResult

class PasswordValidatorImpl(constraint: List<Constraint>) : PasswordValidator {

    private val _constraints: MutableList<Constraint> = mutableListOf()

    init {
        _constraints.addAll(constraint)
    }

    override fun validate(password: String) =
        validatePerChunks(password).all { constraintResult -> constraintResult.valid }

    override fun validatePerChunks(password: String): List<ConstraintResult> {
        val result = _constraints.map { constraint ->
            when (constraint) {
                is CustomConstraint ->
                    ConstraintResult(constraint, password.contains(constraint.regex))
                is RegexConstraint ->
                    ConstraintResult(constraint, password.contains(constraint.regex))
                is MinimumLength ->
                    ConstraintResult(constraint, password.length > constraint.length)
            }
        }
        return result
    }
}
