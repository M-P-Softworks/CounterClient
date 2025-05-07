plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.hilt)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.mpsoftworks.presentation"
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
//    composeOptions{
//        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
//    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildToolsVersion = "34.0.0"
}

dependencies {
    implementation(catalog.core.ktx)
    implementation(catalog.androidx.appcompat.appcompat)

    // DI Dagger
    implementation (catalog.hilt)
    implementation (catalog.hilt.compiler)
    ksp (catalog.hilt.compiler)
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
    implementation(project(":domain"))
    implementation(project(":model"))
}