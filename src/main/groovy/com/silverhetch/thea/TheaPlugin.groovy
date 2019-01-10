package com.silverhetch.thea

import org.gradle.api.Plugin
import org.gradle.api.Project


class TheaPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        def extension = project.extensions.create("thea", TheaPluginExtension)
        project.task("printCurrentStatus") {
            doLast {
                println(new Utilities().getCurrentGitTag())
            }
        }
    }
}
