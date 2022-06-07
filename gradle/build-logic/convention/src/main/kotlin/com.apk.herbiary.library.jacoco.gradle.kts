import com.apk.herbiary.configureJacoco

plugins {
    id("com.android.library")
    jacoco
}

android{
    androidComponents{
        configureJacoco(this)
    }
}