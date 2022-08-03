plugins {
    id("com.apk.herbiary.application")
    id("com.apk.herbiary.application.compose")
    id("com.google.gms.google-services")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("com.apk.herbiary.application.jacoco")
    id("jacoco")
}

android {
    defaultConfig {
        applicationId = "com.apk.herbiary"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName("debug") {
            applicationIdSuffix = ".debug"
            versionNameSuffix = "-DEBUG"
        }
    }

    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {
    //module
    implementation(project(":feature-authentication"))
    implementation(project(":feature-garden"))
    implementation(project(":core-common"))
    implementation(project(":core-ui"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.material)
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.compose.material.iconsExtended)
    implementation(libs.androidx.compose.ui.tooling)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.ui.util)
    implementation(libs.firebase.firestore)
    testImplementation(libs.junit4)

    //hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    implementation(libs.hilt.navigation.compose)

}