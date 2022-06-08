import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import com.apk.herbiary.configureAndroidCompose
import com.apk.herbiary.configureAndroidKotlin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType

class AndroidApplicationConventionPlugin: Plugin<Project> {
    override fun apply(project: Project) {
        with(project){
            with(pluginManager){
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<BaseAppModuleExtension> {
                configureAndroidKotlin(this)
                defaultConfig.targetSdk = 32
            }
        }
    }
}