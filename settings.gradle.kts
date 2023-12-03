rootProject.name = "CounterClient"

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }

    versionCatalogs {
        create("catalog") {
            from(files("gradle/libs.versions.toml"))
        }
    }
}

include(":app")
include(":data")
include(":domain")
include(":presentation")
