package com.larryhsiao.thea.version

class WrappedVersionTest extends GroovyTestCase {
    /**
     * Normal case of a wrapped version.
     */
    void testNormal() {
        Version version = new WrappedVersion(
            new ConstVersion(
                "v1.0.0",
                "flavor"
            )
        );
        assertEquals("1.0.0", version.name())
        assertEquals(10000, version.code())
        assertEquals("flavor", version.flavor())
    }
}
