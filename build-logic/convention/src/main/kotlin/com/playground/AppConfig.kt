package com.playground

import org.gradle.api.JavaVersion

object AppConfig {
    const val applicationId = "com.lab.compose"
    const val minimumSdkVersion = 23
    const val compileSdkVersion = 36
    const val targetSdkVersion = 36
    var testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    val compatibilityVersion = JavaVersion.VERSION_17

    const val versionCode  = 1
    const val versionName  = "1.0.0"
}