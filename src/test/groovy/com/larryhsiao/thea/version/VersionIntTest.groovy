package com.larryhsiao.thea.version

import com.larryhsiao.clotho.ConstSource
import com.larryhsiao.clotho.Source
import org.apache.tools.ant.types.Assertions


class VersionIntTest extends GroovyTestCase {
    void testVer0() {
        assertEquals(
            0,
            new VersionInt(new ConstSource<String>("v0.0.0")).value()
        )
    }

    void testVerNon0() {
        assertNotSame(
            0,
            new VersionInt(new ConstSource<String>("v0.0.1")).value()
        )
    }

    void testVerNonPrefixV() {
        assertNotSame(
            0,
            new VersionInt(new ConstSource<String>("0.0.1")).value()
        )
        assertEquals(
            1,
            new VersionInt(new ConstSource<String>("0.0.1")).value()
        )
    }

    void testInvalidedStringHasException() {
        try {
            new VersionInt(new ConstSource<String>("INVALIDED")).value()
            fail()
        } catch (IllegalArgumentException e) {
            assertTrue(true)
        }
    }

    void testMajorNumber() {
        assertEquals(
            10000,
            new VersionInt(new ConstSource<String>("v1.0.0")).value()
        )
    }

    void testMinorNumber() {
        assertEquals(
            100,
            new VersionInt(new ConstSource<String>("v0.1.0")).value()
        )
    }

    void testPatchNumber() {
        assertEquals(
            1,
            new VersionInt(new ConstSource<String>("v0.0.1")).value()
        )
    }

    void testExceptionFetchingVersion() {
        try {
            new VersionInt(new Source<String>() {
                @Override
                String value() throws Exception {
                    throw new RuntimeException("")
                }
            }).value()
            fail()
        } catch (Exception e) {
            assertEquals(
                "Invalid format of version String",
                e.message
            )
        }
    }
}
