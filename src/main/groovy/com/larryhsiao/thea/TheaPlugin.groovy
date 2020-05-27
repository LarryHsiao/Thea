package com.larryhsiao.thea


import org.gradle.api.Plugin
import org.gradle.api.Project

class TheaPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        project.extensions.create('thea', TheaExtension)
    }
}
