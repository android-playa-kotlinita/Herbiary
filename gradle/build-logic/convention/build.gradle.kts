plugins{
    `kotlin-dsl`
}

group = "com.apk.herbiay.build-logic"

dependencies {
    implementation(libs.android.gradle)
    implementation(libs.kotlin.gradlePlugin)
    implementation(libs.spotless.gradlePlugin)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

gradlePlugin {
    plugins {
        register("androidApplicationCompose") {
            id = "com.apk.herbiary.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidApplication") {
            id = "com.apk.herbiary.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "com.apk.herbiary.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }

        register("androidLibrary") {
            id = "com.apk.herbiary.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("spotless") {
            id = "com.apk.herbiary.spotless"
            implementationClass = "SpotlessConventionPlugin"
        }
    }
}