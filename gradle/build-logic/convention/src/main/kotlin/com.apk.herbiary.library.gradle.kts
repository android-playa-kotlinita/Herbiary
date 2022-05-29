import com.apk.herbiary.configureAndroidKotlin

plugins{
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
}
android{
    configureAndroidKotlin(this)
    defaultConfig{
        targetSdk = 32
    }
}