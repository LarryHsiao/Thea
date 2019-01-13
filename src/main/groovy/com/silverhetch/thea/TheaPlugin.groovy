package com.silverhetch.thea

import com.silverhetch.clotho.source.ConstSource
import com.silverhetch.thea.version.DebugVersion
import com.silverhetch.thea.version.GitHeadTagSource
import com.silverhetch.thea.version.VersionsImpl
import com.silverhetch.thea.version.Version
import org.gradle.api.Plugin
import org.gradle.api.Project


class TheaPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        project.task("PrintVersionStatus") {
            doLast {
                println(new VersionString(
                        new GitHeadTagSource(),

                ).fetch())
            }
        }
    }
}
