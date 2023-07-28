plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id ("com.google.dagger.hilt.android") version "2.47" apply false
}

android {
    compileSdk = 33
    namespace = "com.emotionfactry.counterclient"
    buildToolsVersion = "33.0.2"

    defaultConfig {
        applicationId = "com.emotionfactry.counterclient"
        minSdk = 26
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
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
    buildFeatures{
        viewBinding = true
    }
}

dependencies {
    implementation (catalog.android.core)
    implementation (catalog.appcompat)
    implementation (catalog.material)
    implementation (catalog.junit)
    implementation (catalog.constraint.layout)
    implementation (catalog.lifecycle)
    implementation (catalog.nav.fragment)
    implementation (catalog.nav.ui)

    // DI Dagger
    implementation (catalog.hilt)
    kapt (catalog.hilt.compiler)

    //coroutines
    implementation (catalog.coroutines)
}