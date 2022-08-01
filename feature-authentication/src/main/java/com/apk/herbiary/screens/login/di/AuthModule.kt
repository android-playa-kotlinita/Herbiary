package com.apk.herbiary.screens.login.di

import com.apk.herbiary.password.validator.PasswordValidatorImpl
import com.apk.herbiary.password.validator.abstraction.*
import com.apk.herbiary.screens.login.repository.AuthenticationRepository
import com.apk.herbiary.screens.login.repository.AuthenticationRepositoryImpl
import com.apk.herbiary.screens.login.util.*
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AuthModule {

    @Provides
    fun providesPasswordValidator(): PasswordValidator = PasswordValidatorImpl(constraints)

    @Module
    @InstallIn(SingletonComponent::class)
    interface AuthBindsModule {

        @Binds
        fun bindsLoginRepository(authenticationRepository: AuthenticationRepositoryImpl): AuthenticationRepository
    }

}

val constraints = listOf(
    CapitalLetter,
    LowerCaseLetter,
    Digit,
    SpecialCharacters,
    MinimumLength(8)
)