package com.silverhetch.thea

import com.silverhetch.clotho.Source
import com.silverhetch.thea.version.Version
import com.silverhetch.thea.version.VersionsImpl

/**
 * Source for version indicator String.
 */
class VersionString implements Source<String> {
    private final Source<String[]> tagSource
    private final Source<Version> defaultVersion
    private final String flavor

    VersionString(Source<String[]> tagSource, Source<Version> defaultVersion, String flavor) {
        this.tagSource = tagSource
        this.defaultVersion = defaultVersion
        this.flavor = flavor
    }

    @Override
    String fetch() {
        Version version = new VersionsImpl(
                tagSource,
                defaultVersion
        ).versionByFlavor(flavor)
        return "Git tag: ${version.gitTag()}\n" +
                "Version name: ${version.versionName()}\n" +
                "Version code: ${version.versionCode()}"
    }
}
