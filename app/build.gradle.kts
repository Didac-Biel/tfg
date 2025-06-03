plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services") // Per Firebase
}

android {
    namespace = "com.example.loginshaggin"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.loginshaggin"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        // Aquí afegim la clau directament per Google Maps
        resValue("string", "google_maps_key", "AIzaSyAVme976mRfnuPNxw5DtN3VdrNL1R7IVXE")
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    // Core Android
    implementation(libs.androidx.core.ktx.v1120)
    implementation(libs.androidx.appcompat.v161)
    implementation(libs.material.v1110)
    implementation(libs.androidx.constraintlayout.v214)

    // Firebase Auth
    implementation(libs.firebase.auth.ktx)

    // Google Maps
    implementation(libs.play.services.maps.v1820)
    //implementation 'com.google.android.gms:play-services-location:21.3.0'
    // Tests
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit.v115)
    androidTestImplementation(libs.androidx.espresso.core.v351)
}
