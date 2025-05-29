plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.hilt)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.mpsoftworks.domain"
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
    packaging {
        resources {
            excludes += "META-INF/gradle/incremental.annotation.processors"
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

    // DI Dagger
    implementation (catalog.hilt)
    implementation (catalog.hilt.compiler)
    ksp (catalog.hilt.compiler)

    androidTestImplementation(catalog.androidx.test.ext.junit)
    androidTestImplementation(catalog.espresso.core)

    //project
    implementation(project(":data"))
    implementation(project(":model"))

}