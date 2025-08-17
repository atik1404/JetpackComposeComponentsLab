package com.playground

import com.android.build.api.variant.AndroidComponentsExtension
import com.android.build.gradle.internal.tasks.databinding.DataBindingGenBaseClassesTask
import org.gradle.api.Project
import org.gradle.configurationcache.extensions.capitalized
import org.jetbrains.kotlin.gradle.tasks.AbstractKotlinCompileTool

internal fun Project.configureKSP(
    extension: AndroidComponentsExtension<*, *, *>
) {
    extension.onVariants { variant ->
        afterEvaluate {
            val dataBindingTask =
                project.tasks.findByName("dataBindingGenBaseClasses" + variant.name.capitalized()) as? DataBindingGenBaseClassesTask
            if (dataBindingTask != null) {
                project.tasks.getByName("ksp" + variant.name.capitalized() + "Kotlin") {
                    (this as AbstractKotlinCompileTool<*>).setSource(dataBindingTask.sourceOutFolder)
                }
            }
        }
    }
}