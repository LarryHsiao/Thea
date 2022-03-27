package com.larryhsiao.thea.version

import com.larryhsiao.clotho.Source

/**
 * Version Integer from version String.
 */
class VersionInt implements Source<Integer> {
    private final Source<String> versionString

    VersionInt(Source<String> verisonString) {
        this.versionString = verisonString
    }

    @Override
    Integer value() {
        try {
            def (String major, String minor, String patch) = versionString.value().replaceAll("v", "").split('\\.')
            return (Integer.valueOf(major.trim()) * 10000) +
                (Integer.valueOf(minor.trim()) * 100) +
                Integer.valueOf(patch.trim())
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid format of version String", e)
        }
    }
}
