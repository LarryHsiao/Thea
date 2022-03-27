package com.larryhsiao.thea.version

import com.larryhsiao.clotho.Source

import java.util.regex.Pattern

class ConstVersion implements Version {
    private final String gitTag
    private final String flavor

    ConstVersion(String gitTag, String flavor) {
        this.gitTag = gitTag
        this.flavor = flavor
    }

    @Override
    String tag() {
        return gitTag
    }

    @Override
    String name() {
        return gitTag.replaceAll(flavor + "_v", "")
            .replaceAll(flavor + "_V", "")
            .replaceAll(Pattern.compile("^v"), "")
    }

    @Override
    String flavor() {
        return flavor
    }

    @Override
    int code() {
        return new VersionInt(
            new Source<String>() {
                @Override
                String value() throws Exception {
                    return name()
                }
            }
        ).value()
    }
}
