plugins {
    id ("com.android.library")
    id ("org.jetbrains.kotlin.android")
    id ("com.google.dagger.hilt.android") version "2.47" apply false
}

android {
    compileSdk = 33

    defaultConfig {
        minSdk = 26
        targetSdk = 32

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles = "consumer-rules.pro"
    }

    buildTypes {
        release {
            minifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildToolsVersion = "33.0.2"
    namespace = "com.emotionfactry.presentation"
}

dependencies {

    implementation(catalog.android.core)
    implementation(catalog.lifecycle)
    implementation(catalog.activity)
    implementation(catalog.compose.ui)
    implementation(catalog.compose.ui.tooling)
    implementation(catalog.compose.ui.tooling.preview)
    implementation(catalog.compose.material)
    implementation(catalog.compose.navigation)
}