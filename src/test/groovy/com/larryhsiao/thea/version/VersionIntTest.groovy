package com.larryhsiao.thea.version

import com.silverhetch.clotho.source.ConstSource

class VersionIntTest extends GroovyTestCase {
    void testVer0() {
        assertEquals(
                0,
                new VersionInt(
                        new ConstSource<String>("v0.0.0")
                ).value()
        )
    }

    void testVerNon0() {
        assertNotSame(
                0,
                new VersionInt(
                        new ConstSource<String>("v0.0.1")
                ).value()
        )
    }

    void testVerNonPrefixV() {
        assertNotSame(
                0,
                new VersionInt(
                        new ConstSource<String>("0.0.1")
                ).value()
        )
    }

    void testInvalidedStringHasException() {
        try {
            new VersionInt(
                    new ConstSource<String>("INVALIDED")
            ).value()
            fail()
        } catch (IllegalArgumentException e) {
            assertTrue(true)
        }
    }

    void testMajorNumber() {
        assertEquals(
                10000,
                new VersionInt(
                        new ConstSource<String>("v1.0.0")
                ).value()
        )
    }


    void testMinorNumber() {
        assertEquals(
                100,
                new VersionInt(
                        new ConstSource<String>("v0.1.0")
                ).value()
        )
    }


    void testPatchNumber() {
        assertEquals(
                1,
                new VersionInt(
                        new ConstSource<String>("v0.0.1")
                ).value()
        )
    }

}
