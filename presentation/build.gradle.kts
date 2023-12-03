plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.emotionfactry.presentation"
    compileSdk = 33

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
}

dependencies {
    implementation(catalog.core.ktx)
    implementation(catalog.androidx.appcompat.appcompat)

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
}