package com.silverhetch.thea.version

import com.silverhetch.clotho.Source

/**
 * Versioning by Git tags.
 */
class VersionsImpl implements Versions {
    private final Source<String[]> tagSource
    private final Source<Version> defaultVersion

    VersionsImpl(Source<String[]> tagSource, Source<Version> defaultVersion) {
        this.tagSource = tagSource
        this.defaultVersion = defaultVersion
    }

    @Override
    Version versionByFlavor(String flavor) {
        if (flavor == null || flavor.isEmpty()) {
            throw new IllegalArgumentException("No flavor provided")
        }
        String[] tags = tagSource.fetch()

        for (int i = 0; i < tags.length; i++) {
            if (tags[i].toLowerCase().startsWith(flavor.toLowerCase())) {
                return new ConstVersion(tags[i], flavor)
            }
        }
        return defaultVersion.fetch()
    }
}
