plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.mpsoftworks.domain"
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildToolsVersion = "34.0.0"
}

dependencies {

    implementation(catalog.core.ktx)
    implementation(catalog.androidx.appcompat.appcompat)
    testImplementation(catalog.junit.junit)
    implementation(catalog.hilt)
    androidTestImplementation(catalog.androidx.test.ext.junit)
    androidTestImplementation(catalog.espresso.core)

    //project
    implementation(project(":data"))
}