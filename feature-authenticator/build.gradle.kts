plugins{
    id("com.apk.herbiary.library")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

dependencies{
    implementation(project(":core-model"))
    implementation(project(":core-common"))

    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    implementation(libs.firebase.auth)
    implementation(libs.play.services.coroutines)
    implementation(libs.androidx.core.ktx)
}