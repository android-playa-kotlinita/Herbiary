plugins{
    `kotlin-dsl`
}

group = "com.apk.herbiay.build-logic"

dependencies {
    implementation(libs.android.gradle)
    implementation(libs.kotlin.gradlePlugin)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}