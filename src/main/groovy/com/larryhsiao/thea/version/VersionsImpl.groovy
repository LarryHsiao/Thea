package com.larryhsiao.thea.version

import com.larryhsiao.thea.version.pattern.FlavorVersionPattern
import com.larryhsiao.thea.version.pattern.NonFlavorVersionPattern
import com.silverhetch.clotho.Source

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
        final String[] tags = tagSource.value()
        final Pattern versionPattern = new FlavorVersionPattern(flavor).value()

        for (int i = 0; i < tags.length; i++) {
            if (versionPattern.matcher(tags[i]).matches()) {
                return new ConstVersion(tags[i], flavor)
            }
        }
        return defaultVersion.value()
    }

    private Version findNonFlavorTag() {
        final String[] tags = tagSource.value()
        final Pattern versionpattern = new NonFlavorVersionPattern().value()

        for (int i = 0; i < tags.length; i++) {
            if (versionpattern.matcher(tags[i]).matches()) {
                return new ConstVersion(tags[i], "")
            }
        }
        return defaultVersion.value()
    }

    @Override
    Version version() {
        return byFlavor("")
    }
}
