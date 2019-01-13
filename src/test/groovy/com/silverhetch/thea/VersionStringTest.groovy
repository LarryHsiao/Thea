package com.silverhetch.thea

import com.silverhetch.clotho.source.ConstSource
import com.silverhetch.thea.version.ConstVersion
import com.silverhetch.thea.version.DebugVersion
import com.silverhetch.thea.version.Version
import com.silverhetch.thea.version.VersionString

class VersionStringTest extends GroovyTestCase {
    void testDefaultVersion() {
        assertEquals(
                "Git tag: defaultName_v1.0.0\n" +
                        "Version name: v1.0.0\n" +
                        "Version code: 10000",
                new VersionString(
                        new ConstSource<String[]>(""),
                        new ConstSource<Version>(new ConstVersion(
                                "defaultName_v1.0.0",
                                "defaultName"
                        )), "NoneFlavor"
                ).fetch()
        )
    }

    void testVersion() {
        assertEquals(
                "Git tag: flavorName_v1.0.0\n" +
                        "Version name: v1.0.0\n" +
                        "Version code: 10000",
                new VersionString(
                        new ConstSource<String[]>(
                                ["flavorName_v1.0.0"].toArray(new String[1])
                        ),
                        new ConstSource<Version>(new DebugVersion()),
                        "flavorName"
                ).fetch()
        )
    }

    void testNoFlavorProvidedUsingDefault() {
        assertEquals(
                "Git tag: DefaultName\n" +
                        "Version name: DefaultName\n" +
                        "Version code: 1",
            new VersionString(
                    new ConstSource<String[]>(
                            ["flavorName_v1.0.0"].toArray(new String[1])
                    ),
                    new ConstSource<Version>(new DebugVersion(
                            new ConstSource<String>("DefaultName")
                    )),
                    ""
            ).fetch()
        )
    }

}
