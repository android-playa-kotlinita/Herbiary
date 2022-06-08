pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    includeBuild("gradle/build-logic")
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
enableFeaturePreview("VERSION_CATALOGS")

rootProject.name = "Herbiary"
rootDir.listFiles()?.filter {
    File(it, "build.gradle.kts").exists()
}?.forEach {
    include(it.name)
}