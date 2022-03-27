package com.larryhsiao.thea.version

import com.larryhsiao.clotho.Source

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
    String name() {
        return tag() + "(Debug)"
    }

    @Override
    String tag() {
        return defaultTag.value()
    }

    @Override
    String flavor() {
        return "Debug"
    }

    @Override
    int code() {
        return 1
    }
}
