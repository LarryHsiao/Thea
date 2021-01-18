package com.larryhsiao.thea.version

import com.larryhsiao.clotho.source.ConstSource

class VersionStringTest extends GroovyTestCase {
    void testDefaultVersion() {
        assertEquals(
                "Version---------------------\n" +
                        "tag: defaultName_v1.0.0\n" +
                        "name: 1.0.0\n" +
                        "code: 10000\n" +
                        "============================",
                new VersionString(
                        new ConstSource<String[]>([""].toArray(new String[1])),
                        new ConstSource<String[]>([""].toArray(new String[1])),
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
                        new ConstSource<String[]>(
                                ["flavorName_v1.0.0"].toArray(new String[1])
                        ),
                        new ConstSource<Version>(new DebugVersion()),
                        "flavorName"
                ).value()
        )
    }

    void testVersionNotAtHead() {
        assertEquals(
                "Version---------------------\n" +
                        "tag: flavorName_v1.0.0\n" +
                        "name: 1.0.0(Debug)\n" +
                        "code: 1\n" +
                        "============================",
                new VersionString(
                        new ConstSource<String[]>([""].toArray(new String[1])),
                        new ConstSource<String[]>(["flavorName_v1.0.0"].toArray(new String[1])),
                        new ConstSource<Version>(new DebugVersion(
                                new ConstSource<String>("DefaultName")
                        )),
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
