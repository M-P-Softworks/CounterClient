plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.hilt)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.mpsoftworks.data"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlin {
        sourceSets.all {
            languageSettings.optIn("kotlin.uuid.ExperimentalUuidApi")
        }
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildToolsVersion = "34.0.0"
}

dependencies {
    implementation(catalog.core.ktx)
    implementation (catalog.androidx.appcompat.appcompat)
    implementation(catalog.room.runtime)
    implementation(catalog.room.ktx)
    ksp(catalog.room.ksp)

    // DI Dagger
    implementation (catalog.hilt)
    implementation (catalog.hilt.compiler)
    ksp (catalog.hilt.compiler)

    //project
    implementation(project(":model"))
}