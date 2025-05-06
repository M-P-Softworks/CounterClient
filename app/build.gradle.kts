plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.hilt)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.mpsoftworks.counterclient"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    }
    packaging {
        resources {
            excludes += "META-INF/gradle/incremental.annotation.processors"
        }
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures{
        viewBinding = true
    }
    buildToolsVersion = "34.0.0"
}

dependencies {
    implementation(catalog.core.ktx)
    implementation (catalog.androidx.appcompat.appcompat)

    // DI Dagger
    implementation (catalog.hilt)
    implementation (catalog.hilt.compiler)
    ksp (catalog.hilt.compiler)

    //project
    implementation(project(":data"))
    implementation(project(":domain"))
    implementation(project(":presentation"))

}