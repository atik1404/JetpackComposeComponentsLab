import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "com.playground.buildlogic"
java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradle.plugin)
    compileOnly(libs.firebase.crashlytics.gradle.plugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }

        register("androidLibrary") {
            id = "android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }

        register("androidLibraryCompose") {
            id = "android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }

        register("androidApplicationCompose") {
            id = "android.compose.application"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }

        register("jvmLibrary") {
            id = "jvm.library"
            implementationClass = "JvmLibraryConventionPlugin"
        }

        register("androidHilt"){
            id = "android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }

        register("androidFirebase"){
            id = "android.firebase"
            implementationClass = "AndroidFirebaseConventionPlugin"
        }

        register("featureModule") {
            id = "android.features"
            implementationClass = "AndroidFeatureConventionPlugin"
        }

        register("androidRoom") {
            id = "android.room"
            implementationClass = "AndroidRoomConventionPlugin"
        }
    }
}