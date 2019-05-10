package com.silverhetch.thea.version

import com.silverhetch.clotho.Source
import com.silverhetch.thea.version.pattern.FlavorVersionPattern
import com.silverhetch.thea.version.pattern.NonFlavorVersionPattern

import java.util.regex.Pattern

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
    Version byFlavor(String flavor) {
        if ((flavor == null || flavor.isEmpty())) {
            return findNonFlavorTag()
        }
        final String[] tags = tagSource.fetch()
        final Pattern versionPattern = new FlavorVersionPattern(flavor).fetch()

        for (int i = 0; i < tags.length; i++) {
            if (versionPattern.matcher(tags[i]).matches()) {
                return new ConstVersion(tags[i], flavor)
            }
        }
        return defaultVersion.fetch()
    }

    private Version findNonFlavorTag() {
        final String[] tags = tagSource.fetch()
        final Pattern versionpattern = new NonFlavorVersionPattern().fetch()

        for (int i = 0; i < tags.length; i++) {
            if (versionpattern.matcher(tags[i]).matches()) {
                return new ConstVersion(tags[i], "")
            }
        }
        return defaultVersion.fetch()
    }
}
