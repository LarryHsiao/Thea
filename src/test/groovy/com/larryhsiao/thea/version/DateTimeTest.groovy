package com.larryhsiao.thea.version

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
