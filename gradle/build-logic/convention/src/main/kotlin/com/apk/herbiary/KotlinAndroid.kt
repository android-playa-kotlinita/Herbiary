package com.apk.herbiary

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

fun Project.configureAndroidKotlin(commonExtension: CommonExtension<*, *, *, *>) {
    commonExtension.apply {
        compileSdk = 32
        defaultConfig{
            minSdk = 26
        }
        compileOptions{
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }
        kotlinOptions{
            jvmTarget = JavaVersion.VERSION_1_8.toString()
        }
    }
}

private fun CommonExtension<*, *, *, *>.kotlinOptions(block: KotlinJvmOptions.() -> Unit) {
    (this as ExtensionAware).extensions.configure("kotlinOptions", block)
}