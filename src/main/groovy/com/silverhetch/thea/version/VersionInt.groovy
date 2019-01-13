package com.silverhetch.thea.version

import com.silverhetch.clotho.Source

/**
 * Version Integer from version String.
 */
class VersionInt implements Source<Integer> {
    private final Source<String> versionString

    public VersionInt(Source<String> verisonString) {
        this.versionString = verisonString
    }

    @Override
    Integer fetch() {
        try {
            def (major, minor, patch) = versionString.fetch().replaceAll("v", "").split('\\.')
            return (Integer.valueOf(major.trim()) * 10000) +
                    (Integer.valueOf(minor.trim()) * 100) +
                    Integer.valueOf(patch.trim())
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid format of version String")
        }
    }
}
