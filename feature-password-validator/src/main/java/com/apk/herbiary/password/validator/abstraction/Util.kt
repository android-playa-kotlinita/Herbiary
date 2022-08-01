package com.apk.herbiary.password.validator.abstraction

import com.apk.herbiary.password.validator.abstraction.ConstraintConstants.CAPITAL_LETTER_CONSTRAINT
import com.apk.herbiary.password.validator.abstraction.ConstraintConstants.DIGIT_CONSTRAINT
import com.apk.herbiary.password.validator.abstraction.ConstraintConstants.LOWER_LETTER_CONSTRAINT
import com.apk.herbiary.password.validator.abstraction.ConstraintConstants.MINIMUM_LENGTH
import com.apk.herbiary.password.validator.abstraction.ConstraintConstants.SPECIAL_CHARACTER_CONSTRAINT

sealed class RegexConstraint(override val key: String, val regex: Regex) : Constraint

object CapitalLetter : RegexConstraint(CAPITAL_LETTER_CONSTRAINT, "[A-Z]".toRegex())

object LowerCaseLetter : RegexConstraint(LOWER_LETTER_CONSTRAINT, "[a-z]".toRegex())

object Digit : RegexConstraint(DIGIT_CONSTRAINT, "\\d".toRegex())

object SpecialCharacters : RegexConstraint(SPECIAL_CHARACTER_CONSTRAINT, "[@\$!%*?&<>.]".toRegex())

data class MinimumLength(val length: Int) : Constraint {
    override val key: String = MINIMUM_LENGTH
}

open class CustomConstraint(override val key: String, val regex: Regex) : Constraint

object ConstraintConstants {
    const val CAPITAL_LETTER_CONSTRAINT = "capital"
    const val LOWER_LETTER_CONSTRAINT = "lower"
    const val DIGIT_CONSTRAINT = "digit"
    const val SPECIAL_CHARACTER_CONSTRAINT = "special"
    const val MINIMUM_LENGTH = "minimum"
}
