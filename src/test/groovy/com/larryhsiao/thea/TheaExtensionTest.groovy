package com.larryhsiao.thea

import com.larryhsiao.clotho.source.ConstSource

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
            ).version().versionName()
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
            ).byFlavor("flavor").versionName()
        )
    }
}
