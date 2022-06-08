import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import com.apk.herbiary.configureAndroidCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

class AndroidLibraryComposeConventionPlugin: Plugin<Project> {
    override fun apply(project: Project) {
        with(project){
            pluginManager.apply("com.android.library")
            val extension = extensions.getByType<BaseAppModuleExtension>()
            configureAndroidCompose(extension)
        }
    }
}