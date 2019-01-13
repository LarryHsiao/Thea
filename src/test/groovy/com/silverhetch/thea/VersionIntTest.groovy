package com.silverhetch.thea

import com.silverhetch.clotho.source.ConstSource
import com.silverhetch.thea.version.VersionInt

class VersionIntTest extends GroovyTestCase {
    void testVer0() {
        assertEquals(
                0,
                new VersionInt(
                        new ConstSource<String>("v0.0.0")
                ).fetch()
        )
    }

    void testVerNon0() {
        assertNotSame(
                0,
                new VersionInt(
                        new ConstSource<String>("v0.0.1")
                ).fetch()
        )
    }

    void testVerNonPrefixV() {
        assertNotSame(
                0,
                new VersionInt(
                        new ConstSource<String>("0.0.1")
                ).fetch()
        )
    }

    void testInvalidedStringHasException() {
        try {
            new VersionInt(
                    new ConstSource<String>("INVALIDED")
            ).fetch()
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
                ).fetch()
        )
    }


    void testMinorNumber() {
        assertEquals(
                100,
                new VersionInt(
                        new ConstSource<String>("v0.1.0")
                ).fetch()
        )
    }


    void testPatchNumber() {
        assertEquals(
                1,
                new VersionInt(
                        new ConstSource<String>("v0.0.1")
                ).fetch()
        )
    }

}
