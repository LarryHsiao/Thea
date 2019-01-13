package com.silverhetch.thea


import org.gradle.api.Plugin
import org.gradle.api.Project

class TheaPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        def extension = project.extensions.create('theaVersion', TheaExtension)
        project.task("PrintNonFlavorStatus") {
            doLast {
                println("Version Name: ${extension.versionName("")}")
                println("Version Code: ${extension.versionCode("")}")
            }
        }
    }
}
