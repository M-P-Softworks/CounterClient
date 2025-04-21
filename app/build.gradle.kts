plugins {
    id(libs.plugins.android.application.get().pluginId)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.mpsoftworks.counterclient"
    compileSdk = 34

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

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

    //project
    implementation(project(":data"))
    implementation(project(":domain"))
    implementation(project(":presentation"))

}