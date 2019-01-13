package com.silverhetch.thea.version

import com.silverhetch.clotho.Source

/**
 * A debug Version, which we can not find any tag by flavor at HEAD by git command.
 */
class DebugVersion implements Version {
    private final Source<String> defaultTag

    DebugVersion(Source<String> defaultTag) {
        this.defaultTag = defaultTag
    }

    DebugVersion() {
        this(new DateTime())
    }

    @Override
    String versionName() {
        return gitTag()
    }

    @Override
    String gitTag() {
        return defaultTag.fetch()
    }

    @Override
    String flavor() {
        return ""
    }

    @Override
    int versionCode() {
        return 1
    }
}
