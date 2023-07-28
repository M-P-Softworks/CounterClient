rootProject.name = "CounterClient"

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
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
include(":domain(maybe_not_need)")
include(":presentation")
