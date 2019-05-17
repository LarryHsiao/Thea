package com.silverhetch.thea

import com.silverhetch.thea.version.DateTime

/**
 * Test the DateTime source
 */
class DateTimeTest extends GroovyTestCase {
    void testSimple() {
        assertEquals(
                12,
                new DateTime().value().length()
        )
    }
}
