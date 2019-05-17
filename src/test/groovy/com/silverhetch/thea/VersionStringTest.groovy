package com.silverhetch.thea

import com.silverhetch.clotho.source.ConstSource
import com.silverhetch.thea.version.ConstVersion
import com.silverhetch.thea.version.DebugVersion
import com.silverhetch.thea.version.Version
import com.silverhetch.thea.version.VersionString

class VersionStringTest extends GroovyTestCase {
    void testDefaultVersion() {
        assertEquals(
                "Version---------------------\n" +
                        "tag: defaultName_v1.0.0\n" +
                        "name: 1.0.0\n" +
                        "code: 10000\n" +
                        "============================",
                new VersionString(
                        new ConstSource<String[]>(""),
                        new ConstSource<Version>(new ConstVersion(
                                "defaultName_v1.0.0",
                                "defaultName"
                        )), "NoneFlavor"
                ).value()
        )
    }

    void testVersion() {
        assertEquals(
                "Version---------------------\n" +
                        "tag: flavorName_v1.0.0\n" +
                        "name: 1.0.0\n" +
                        "code: 10000\n" +
                        "============================",
                new VersionString(
                        new ConstSource<String[]>(
                                ["flavorName_v1.0.0"].toArray(new String[1])
                        ),
                        new ConstSource<Version>(new DebugVersion()),
                        "flavorName"
                ).value()
        )
    }

    void testNoFlavorProvidedUsingDefault() {
        assertEquals(
                "Version---------------------\n" +
                        "tag: DefaultName\n" +
                        "name: DefaultName(Debug)\n" +
                        "code: 1\n" +
                        "============================",
            new VersionString(
                    new ConstSource<String[]>(
                            ["flavorName_v1.0.0"].toArray(new String[1])
                    ),
                    new ConstSource<Version>(new DebugVersion(
                            new ConstSource<String>("DefaultName")
                    )),
                    ""
            ).value()
        )
    }

}
