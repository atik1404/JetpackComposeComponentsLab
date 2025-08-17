
import com.android.build.api.variant.LibraryAndroidComponentsExtension
import com.android.build.gradle.LibraryExtension
import com.playground.AppConfig
import com.playground.configureKSP
import com.playground.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("android.library")
                apply("android.hilt")
                apply("android.library.compose")
            }
            extensions.configure<LibraryExtension> {
                defaultConfig {
                    testInstrumentationRunner = AppConfig.testInstrumentationRunner
                }
            }

            extensions.configure<LibraryAndroidComponentsExtension> {
                configureKSP(this)
            }

            dependencies {
                add("implementation", libs.findBundle("androidx.core.dependencies").get())
                add("implementation", libs.findBundle("androidx.lifecycle.dependencies").get())
                add("implementation", libs.findBundle("androidx.navigation.dependencies").get())
                add("implementation", libs.findBundle("android.compose.feature.dependencies").get())

                add("implementation", libs.findLibrary("timber").get())
                add("implementation", libs.findLibrary("kotlin.coroutines").get())
                add("implementation", libs.findLibrary("androidx.compose.constraintlayout").get())
                add("debugImplementation", libs.findLibrary("androidx.compose.ui.tooling").get())

                add("testImplementation", libs.findLibrary("test.junit").get())
                add("androidTestImplementation", libs.findLibrary("test.androidx.junit").get())
                add( "androidTestImplementation",libs.findLibrary("test.androidx.espresso.core").get())
            }
        }
    }
}
