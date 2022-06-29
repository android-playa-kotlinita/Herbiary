package com.apk.herbiary.screens.login.di

import com.apk.herbiary.screens.login.repository.FakeLoginRepository
import com.apk.herbiary.screens.login.repository.LoginRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AuthModule {

    @Binds
    abstract fun bindsLoginRepository(fakeLoginRepository: FakeLoginRepository): LoginRepository

}