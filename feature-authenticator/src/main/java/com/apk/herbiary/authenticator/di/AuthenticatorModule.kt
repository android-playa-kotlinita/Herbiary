package com.apk.herbiary.authenticator.di

import com.apk.herbiary.authenticator.FirebaseAuthenticatorImpl
import com.apk.herbiary.authenticator.Authenticator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface AuthenticatorModule {

    @Binds
    fun bindsAuthenticator(authenticator: FirebaseAuthenticatorImpl): Authenticator

}
