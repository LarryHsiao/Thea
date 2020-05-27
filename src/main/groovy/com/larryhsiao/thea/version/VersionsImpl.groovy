package com.larryhsiao.thea.version

import com.larryhsiao.thea.version.pattern.FlavorVersionPattern
import com.larryhsiao.thea.version.pattern.NonFlavorVersionPattern
import com.silverhetch.clotho.Source

import java.util.regex.Pattern

/**
 * Versioning by Git tags.
 */
class VersionsImpl implements Versions {
    private final Source<String[]> headTags;
    private final Source<String[]> allTags
    private final Source<Version> defaultVersion

    VersionsImpl(
            Source<String[]> headTags,
            Source<String[]> allTags,
            Source<Version> defaultVersion) {
        this.headTags = headTags
        this.allTags = allTags
        this.defaultVersion = defaultVersion
    }

    @Override
    Version byFlavor(String flavor) {
        if ((flavor == null || flavor.isEmpty())) {
            return findNonFlavorTag()
        }
        final String[] headTags = new HashSet<String>(Arrays.asList(headTags.value()))
        final String[] allTags = this.allTags.value()
        final Pattern versionPattern = new FlavorVersionPattern(flavor).value()

        for (int i = 0; i < allTags.length; i++) {
            if (versionPattern.matcher(allTags[i]).matches()) {
                if (headTags.contains(allTags[i])) {
                    return new ConstVersion(allTags[i], flavor)
                } else {
                    return defaultVersion.value()
                }
            }
        }
        return defaultVersion.value()
    }

    private Version findNonFlavorTag() {
        final String[] headTags = new HashSet<String>(Arrays.asList(headTags.value()))
        final String[] allTags = this.allTags.value()
        final Pattern versionPattern = new NonFlavorVersionPattern().value()

        for (int i = 0; i < allTags.length; i++) {
            if (versionPattern.matcher(allTags[i]).matches()) {
                if (headTags.contains(allTags[i])) {
                    return new ConstVersion(allTags[i], "")
                } else {
                    return defaultVersion.value()
                }
            }
        }
        return defaultVersion.value()
    }

    @Override
    Version version() {
        return byFlavor("")
    }
}
