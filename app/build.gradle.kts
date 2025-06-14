plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.example.finalassignment_1"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.finalassignment_1"
        minSdk = 28
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }
}

    dependencies {
        // Hilt
        implementation("com.google.dagger:hilt-android:2.48")
        kapt("com.google.dagger:hilt-android-compiler:2.48")

        // Javapoet (required internally by Hilt)
        implementation("com.squareup:javapoet:1.13.0")

        // Retrofit & Moshi
        implementation("com.squareup.retrofit2:retrofit:2.9.0")
        implementation("com.squareup.retrofit2:converter-moshi:2.9.0")
        implementation("com.squareup.moshi:moshi-kotlin:1.14.0")

        // AndroidX
        implementation("androidx.core:core-ktx:1.12.0")
        implementation("androidx.appcompat:appcompat:1.6.1")
        implementation("androidx.activity:activity-ktx:1.7.2")
        implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")

        implementation("androidx.compose.material3:material3:1.2.0")
        implementation("com.google.android.material:material:1.9.0")
        implementation("com.google.android.material:material:1.11.0")


    }


