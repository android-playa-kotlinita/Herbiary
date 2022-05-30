import com.apk.herbiary.configureAndroidKotlin

plugins{
    id("com.android.application")
    kotlin("android")
}
android{
    configureAndroidKotlin(this)
    defaultConfig{
        targetSdk = 32
    }
}