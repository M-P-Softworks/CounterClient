plugins {
    id ("com.android.library")
    id ("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
}

android {
    compileSdk = 33

    defaultConfig {
        minSdk = 26
        targetSdk = 32

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    buildToolsVersion = "33.0.2"
    namespace = "com.emotionfactry.data"
}

dependencies {
    implementation (catalog.android.core)
    implementation (catalog.appcompat)
    implementation (catalog.material)
    implementation (catalog.junit)

    // DI Dagger
    implementation (catalog.hilt)
    kapt (catalog.hilt.compiler)

    //coroutines
    implementation (catalog.coroutines)
}