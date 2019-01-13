package com.silverhetch.thea

import com.silverhetch.clotho.source.ConstSource
import com.silverhetch.thea.version.DebugVersion
import com.silverhetch.thea.version.Version
import com.silverhetch.thea.version.VersionsImpl
import org.gradle.api.DefaultTask
import org.gradle.api.Project
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction

class GenerateTask extends DefaultTask {
    private final Property<String> flavorName

    public GenerateTask() {
        this.flavorName = getProject().getObjects().property(String.class)
    }

    @Input
    public Property<String> getFlavorName() {
        return flavorName
    }

    @TaskAction
    public void executes() {
        Version version = new VersionsImpl(
                new ConstSource<String[]>(
                        new String[0]
                ),
                new ConstSource<Version>(
                        new DebugVersion()
                )
        ).versionByFlavor(flavorName.get())

        final VersionExtension extension = getProject().getExtensions().create("${flavorName}Version", VersionExtension.class, getProject()) as VersionExtension
        extension.versionName = version.versionName()
        extension.versionCode = version.versionCode()
    }

}
