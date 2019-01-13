package com.silverhetch.thea.version.pattern

import com.silverhetch.clotho.Source

import java.util.regex.Pattern

/**
 * A pattern source that only contains version.
 * e.g. v1.0.0
 */
class NonFlavorVersionPattern implements Source<Pattern> {
    @Override
    Pattern fetch() {
        return Pattern.compile("^v[0-9]{1,2}\\.[0-9]{1,2}\\.[0-9]{1,2}\$")
    }
}