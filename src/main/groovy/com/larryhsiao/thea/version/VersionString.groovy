package com.larryhsiao.thea.version

import com.larryhsiao.clotho.Source

/**
 * Source for version indicator String.
 */
class VersionString implements Source<String> {
    private final Source<String[]> headTags
    private final Source<String[]> tagSource
    private final Source<Version> defaultVersion
    private final String flavor

    VersionString(
            Source<String[]> headTags,
            Source<String[]> tagSource,
            Source<Version> defaultVersion,
            String flavor
    ) {
        this.headTags = headTags
        this.tagSource = tagSource
        this.defaultVersion = defaultVersion
        this.flavor = flavor
    }

    @Override
    String value() {
        Version version = new VersionsImpl(
                headTags,
                tagSource,
                defaultVersion
        ).byFlavor(flavor)
        return "Version---------------------\n" +
                "tag: ${version.tag()}\n" +
                "name: ${version.name()}\n" +
                "code: ${version.code()}\n" +
                "============================"
    }
}
