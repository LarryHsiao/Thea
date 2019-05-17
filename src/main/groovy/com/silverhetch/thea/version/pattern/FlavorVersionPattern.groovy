package com.silverhetch.thea.version.pattern

import com.silverhetch.clotho.Source

import java.util.regex.Pattern

/**
 * Pattern source that contains flavor name and versions.
 */
class FlavorVersionPattern implements Source<Pattern> {
    private final String flavor

    FlavorVersionPattern(String flavor) {
        this.flavor = flavor
    }

    @Override
    Pattern value() {
        if (flavor == null || flavor.isEmpty()) {
            throw new IllegalArgumentException("The flavor should never be empty.")
        }

        return Pattern.compile("^${flavor}_v[0-9]{1,2}\\.[0-9]{1,2}\\.[0-9]{1,2}\$")
    }
}
