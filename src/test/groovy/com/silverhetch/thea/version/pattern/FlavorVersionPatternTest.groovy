package com.silverhetch.thea.version.pattern

class FlavorVersionPatternTest extends GroovyTestCase {
    void testSimpleCorrect() {
        assertTrue(
                new FlavorVersionPattern("FlavorName").fetch().matcher(
                        "FlavorName_v1.0.0"
                ).matches()
        )
    }

    void testNoFlavor() {
        assertFalse(
                new FlavorVersionPattern("FlavorName").fetch().matcher(
                        "v1.0.0"
                ).matches()
        )
    }

    void testWrongFlavor() {
        assertFalse(
                new FlavorVersionPattern("FlavorName").fetch().matcher(
                        "PhantomFlavor_v1.0.0"
                ).matches()
        )
    }

    void testExceptionWithEmptyFlavor() {
        try {
            new FlavorVersionPattern("").fetch().matcher(
                    "v1.0.0"
            ).matches()
            fail()
        }catch (Exception ignore){
            assertTrue(true)
        }
    }
}
