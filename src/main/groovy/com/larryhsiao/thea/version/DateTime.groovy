package com.larryhsiao.thea.version

import com.larryhsiao.clotho.Source

/**
 * Date time indicator string.
 */
class DateTime implements Source<String> {
    @Override
    String value() {
        def date = new Date()
        return date.format('yyyyMMddHHmm')
    }
}
