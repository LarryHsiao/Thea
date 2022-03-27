package com.larryhsiao.thea

import com.larryhsiao.clotho.ConstSource


class TheaExtensionTest extends GroovyTestCase {
    void testVersion() {
        assertEquals(
            "1.0.0",
            new TheaExtension(
                new ConstSource<String[]>(
                    ["v1.0.0"].toArray(new String[1])
                ),
                new ConstSource<String[]>(
                    ["v1.0.0"].toArray(new String[1])
                )
            ).version().name()
        )
    }

    void testByFlavor() {
        assertEquals(
            "1.0.1",
            new TheaExtension(
                new ConstSource<String[]>(
                    ["flavor_v1.0.1"].toArray(new String[1])
                ),
                new ConstSource<String[]>(
                    ["flavor_v1.0.1"].toArray(new String[1])
                )
            ).byFlavor("flavor").name()
        )
    }

    /**
     * Test the indicator output that current head have tag.
     */
    void testIndicatorRelease(){
        assertEquals(
            "Version---------------------\n" +
                "tag: flavor_v1.0.1\n" +
                "name: 1.0.1\n" +
                "code: 10001\n" +
                "============================",
            new TheaExtension(
                new ConstSource<String[]>(
                    ["flavor_v1.0.1"].toArray(new String[1])
                ),
                new ConstSource<String[]>(
                    ["flavor_v1.0.1"].toArray(new String[1])
                )
            ).indicator("flavor")
        )
    }

    /**
     * Test the indicator outputs the debug version.
     */
    void testIndicatorDebug(){
        assertEquals(
            "Version---------------------\n" +
                "tag: flavor_v1.0.1\n" +
                "name: 1.0.1(Debug)\n" +
                "code: 1\n" +
                "============================",
            new TheaExtension(
                new ConstSource<String[]>(
                    [""].toArray(new String[1])
                ),
                new ConstSource<String[]>(
                    ["flavor_v1.0.1"].toArray(new String[1])
                )
            ).indicator("flavor")
        )
    }
}
