import com.apk.herbiary.configureAndroidCompose

plugins{
    id("com.android.application")
    kotlin("android")
}
android{
    configureAndroidCompose(this)
    defaultConfig{
        targetSdk = 32
    }
}