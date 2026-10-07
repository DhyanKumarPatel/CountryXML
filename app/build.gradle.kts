plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
}

android {
    namespace = "com.example.sampletest"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.sampletest"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures{
        viewBinding = true
    }
}

dependencies {
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)

    // Retrofit core networking library
    implementation(libs.retrofit)

    // Converter factory for JSON parsing (Gson example)
    implementation(libs.retrofit.converter.gson)

    implementation(libs.androidx.lifecycle.viewmodel.ktx)

    // Jetpack Compose integration (Only include if using Compose)
    implementation(libs.androidx.lifecycle.viewmodel.compose)

    implementation(libs.androidx.recyclerview)

    //hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
}