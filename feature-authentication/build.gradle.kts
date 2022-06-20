plugins{
    id("com.apk.herbiary.library")
    id("com.apk.herbiary.library.compose")
}

dependencies{
    implementation(libs.androidx.compose.material)
    implementation(libs.hilt.navigation.compose)

}