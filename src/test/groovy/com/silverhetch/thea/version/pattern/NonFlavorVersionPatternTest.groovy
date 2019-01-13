package com.silverhetch.thea.version.pattern

class NonFlavorVersionPatternTest extends GroovyTestCase {
    void testCorrect() {
        assertTrue(
                new NonFlavorVersionPattern().fetch().matcher(
                        "v1.0.0"
                ).matches()
        )
    }

    void testWithFlavor() {
        assertFalse(
                new NonFlavorVersionPattern().fetch().matcher(
                        "flavor_v1.0.0"
                ).matches()
        )
    }

    void testLargeVersion(){
        assertTrue(
                new NonFlavorVersionPattern().fetch().matcher(
                        "v99.99.99"
                ).matches()
        )
    }
}
