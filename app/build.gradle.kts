plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "ir.net_box.test"
    compileSdk = 35

    defaultConfig {
        applicationId = "ir.net_box.test"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    // Compose for TV
    implementation(libs.androidx.tv.foundation)
    implementation(libs.androidx.tv.material)

    // Compose core
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.foundation)
    implementation(libs.androidx.ui)

    // Android core
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)

    // Debug and Testing
    androidTestImplementation(platform(libs.androidx.compose.bom))
//    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.test.manifest)
    debugImplementation(libs.androidx.ui.tooling)

    // Hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)

    // Retrofit & Moshi
    implementation (libs.retrofit)
    implementation (libs.moshi.kotlin)
    implementation (libs.converter.moshi)

    // Room
    implementation(libs.androidx.room.runtime)
    ksp(libs.androidx.room.compiler)
    implementation(libs.androidx.room.ktx)

    // Paging
    implementation (libs.androidx.paging.runtime)
    implementation (libs.paging.compose)

    // ExoPlayer
    implementation (libs.media3.exoplayer)
    implementation (libs.androidx.media3.ui)

    // Lifecycle
    implementation (libs.androidx.lifecycle.runtime.ktx.v280)
    implementation (libs.androidx.lifecycle.viewmodel.compose)

    // Coil
    implementation (libs.coil.compose)
}