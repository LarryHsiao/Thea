package com.larryhsiao.thea.version.pattern

class NonFlavorVersionPatternTest extends GroovyTestCase {
    void testCorrect() {
        assertTrue(
                new NonFlavorVersionPattern().value().matcher(
                        "v1.0.0"
                ).matches()
        )
    }

    void testWithFlavor() {
        assertFalse(
                new NonFlavorVersionPattern().value().matcher(
                        "flavor_v1.0.0"
                ).matches()
        )
    }

    void testLargeVersion(){
        assertTrue(
                new NonFlavorVersionPattern().value().matcher(
                        "v99.99.99"
                ).matches()
        )
    }
}
