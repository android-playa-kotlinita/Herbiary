import com.apk.herbiary.configureAndroidKotlin

plugins{
    id("com.android.library")
    kotlin("android")
}
android{
    configureAndroidKotlin(this)
    defaultConfig{
        targetSdk = 32
    }
}