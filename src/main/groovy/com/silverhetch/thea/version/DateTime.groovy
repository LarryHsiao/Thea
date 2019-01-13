package com.silverhetch.thea.version

import com.silverhetch.clotho.Source

/**
 * Date time indicator string.
 */
class DateTime implements Source<String> {
    @Override
    String fetch() {
        def date = new Date()
        return date.format('yyyyMMddHHmm')
    }
}
