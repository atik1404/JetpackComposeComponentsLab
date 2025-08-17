import com.android.build.api.dsl.LibraryExtension
import com.playground.AppConfig
import com.playground.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class ProductFlavourConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)
                defaultConfig.targetSdk = AppConfig.targetSdkVersion

                flavorDimensions += "flavour_demo"
                productFlavors {
                    create("alpha"){
                        //applicationIdSuffix = ".alpha"
                        dimension = "flavour_demo"
                    }

                    create("beta"){
                        //applicationIdSuffix = ".beta"
                        dimension = "flavour_demo"
                    }
                }
            }
        }
    }
}