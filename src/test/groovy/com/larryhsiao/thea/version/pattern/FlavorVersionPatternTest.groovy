package com.larryhsiao.thea.version.pattern

class FlavorVersionPatternTest extends GroovyTestCase {
    void testSimpleCorrect() {
        assertTrue(
                new FlavorVersionPattern("FlavorName").value().matcher(
                        "FlavorName_v1.0.0"
                ).matches()
        )
    }

    void testNoFlavor() {
        assertFalse(
                new FlavorVersionPattern("FlavorName").value().matcher(
                        "v1.0.0"
                ).matches()
        )
    }

    void testWrongFlavor() {
        assertFalse(
                new FlavorVersionPattern("FlavorName").value().matcher(
                        "PhantomFlavor_v1.0.0"
                ).matches()
        )
    }

    void testExceptionWithEmptyFlavor() {
        try {
            new FlavorVersionPattern("").value().matcher(
                    "v1.0.0"
            ).matches()
            fail()
        }catch (Exception ignore){
            assertTrue(true)
        }
    }
}
