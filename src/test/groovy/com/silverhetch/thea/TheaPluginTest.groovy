package com.silverhetch.thea

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder

class TheaPluginTest extends GroovyTestCase {

    void testAvailable() {
        Project project = ProjectBuilder.builder().withName("Phantom").build()
        project.pluginManager.apply TheaPlugin

        assertTrue(project.getPluginManager().hasPlugin("com.silverhetch.thea"))
        assertNotNull(project.tasks.PrintVersionStatus)
    }
}
