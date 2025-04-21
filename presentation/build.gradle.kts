plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.mpsoftworks.presentation"
    compileSdk = 34

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    buildFeatures {
        compose = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    composeOptions{
        kotlinCompilerExtensionVersion = "1.5.3"
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildToolsVersion = "34.0.0"
}

dependencies {
    implementation(catalog.core.ktx)
    implementation(catalog.androidx.appcompat.appcompat)
    implementation(catalog.hilt)
    implementation(catalog.hilt.navigation.compose)

    //navigation
    implementation(catalog.nav.fragment)
    implementation(catalog.nav.ui)

    //compose
    implementation(catalog.compose.activity)
    implementation(catalog.compose.ui)
    implementation(catalog.compose.runtime)
    implementation(catalog.compose.navigation)
    implementation(catalog.compose.ui.tooling)
    implementation(catalog.compose.ui.tooling.preview)
    implementation(catalog.compose.material3)


    //project
    implementation(project(":data"))
    implementation(project(":domain"))
}