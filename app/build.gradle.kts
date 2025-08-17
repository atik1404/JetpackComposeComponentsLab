import com.playground.AppConfig
plugins {
    alias(libs.plugins.android.application.convention.plugin)
    alias(libs.plugins.android.compose.convention.plugin)
    alias(libs.plugins.android.hilt.convention.plugin)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = AppConfig.applicationId
    compileSdk = AppConfig.compileSdkVersion

    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdk = AppConfig.minimumSdkVersion
        targetSdk = AppConfig.targetSdkVersion
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = AppConfig.testInstrumentationRunner
        vectorDrawables {
            useSupportLibrary = true
        }
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
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.2"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.bundles.androidx.core.dependencies)
    implementation(libs.bundles.androidx.lifecycle.dependencies)
    implementation(libs.bundles.androidx.navigation.dependencies)

    implementation(libs.bundles.android.compose.dependencies)
    implementation(libs.bundles.android.compose.feature.dependencies)

    implementation(libs.bundles.rxjava3.dependencies)
    implementation(libs.bundles.pager.dependencies)
    implementation(libs.bundles.network.dependencies)

    implementation(libs.image.coil)
    implementation(libs.timber)
    debugImplementation(libs.leakcanary)

//    implementation(platform(libs.firebase.bom))
//    implementation(libs.firebase.analytics)
//    implementation(libs.firebase.crashlytics)

    testImplementation(libs.test.junit)
    androidTestImplementation(libs.test.androidx.junit)
    androidTestImplementation(libs.test.androidx.espresso.core)
    androidTestImplementation(libs.test.androidx.compose.ui.junit)
    androidTestImplementation(libs.test.androidx.compose.ui.manifest)
    debugImplementation(libs.test.androidx.compose.ui.tooling)
}