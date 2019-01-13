package com.silverhetch.thea

import org.gradle.api.Action
import org.gradle.api.Plugin
import org.gradle.api.Project

class TheaPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        def theaParams = project.extensions.create('thea', TheaExtension)

        String[] flavors = theaParams.getValidFlavor()
        for (int i = 0; i < flavors.length; i++) {
            project.getTasks().register("update${flavors[i]}Version", GenerateTask.class, new Action<GenerateTask>() {
                @Override
                void execute(GenerateTask generateTask) {
                    generateTask.getFlavorName().set(flavors[i])
                }
            })
        }
    }
}
