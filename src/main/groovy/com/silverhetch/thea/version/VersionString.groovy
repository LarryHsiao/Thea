package com.silverhetch.thea.version

import com.silverhetch.clotho.Source

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
    String value() {
        Version version = new VersionsImpl(
                tagSource,
                defaultVersion
        ).byFlavor(flavor)
        return "Version---------------------\n" +
                "tag: ${version.gitTag()}\n" +
                "name: ${version.versionName()}\n" +
                "code: ${version.versionCode()}\n" +
                "============================"
    }
}
