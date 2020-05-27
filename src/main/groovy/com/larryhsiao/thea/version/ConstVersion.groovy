package com.larryhsiao.thea.version

import com.silverhetch.clotho.source.ConstSource

import java.util.regex.Pattern

class ConstVersion implements Version {
    private final String gitTag
    private final String flavor

    ConstVersion(String gitTag, String flavor) {
        this.gitTag = gitTag
        this.flavor = flavor
    }

    ConstVersion(String tag) {
        this(tag, "")
    }

    @Override
    String gitTag() {
        return gitTag
    }

    @Override
    String versionName() {
        return gitTag.replaceAll(flavor + "_v", "")
                .replaceAll(flavor + "_V", "")
                .replaceAll(Pattern.compile("^v"), "")
    }

    @Override
    String flavor() {
        return flavor
    }

    @Override
    int versionCode() {
        return new VersionInt(
                new ConstSource<String>(
                        versionName()
                )
        ).value()
    }
}
