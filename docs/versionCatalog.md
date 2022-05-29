### Version catalog
It's a new feature introduced in Gradle 7.0, making life easier in multi-modules app, making a catalog to retrieve all the dependencies needed and shared between the different modules.

### Setup
The dependencies are declared on [libs.versions.toml](../../gradle/libs.version.toml) using the next structure: 
```
[versions]
variableVersionRef = "1.1.0"

[libraries]
librarie-ref-name = {group = "com.package.name", name = "artifact", version.ref = "variableVersionRef"}
```

In [settings.gradle.kts](../../gradle/build-logic/settings.gradle.kts) on `dependencyResolutionManagement` block you add the next code: 

```
    versionCatalogs{
        create("libs"){
            from(files("../libs.versions.toml"))
        }
    }
```

Finally sync gradle and build your config, in order to use version catalogs.

### Usage
```
dependencies {
    implementation(libs.android.gradle)
    implementation(libs.kotlin.gradlePlugin)
}
```