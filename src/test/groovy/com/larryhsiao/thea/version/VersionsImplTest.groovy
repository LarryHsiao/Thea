package com.larryhsiao.thea.version

import com.larryhsiao.clotho.source.ConstSource

class VersionsImplTest extends GroovyTestCase {
    void testDefaultTag() {
        assertEquals(
            "Version Name",
            new VersionsImpl(
                new ConstSource<String[]>(new String[0]),
                new ConstSource<String[]>(new String[0]),
                new ConstSource<Version>(
                    new DebugVersion(
                        new ConstSource<String>("Version Name")
                    )
                )
            ).byFlavor("SampleFlavor").gitTag()
        )
    }

    void testDefaultVersionName() {
        assertEquals(
            "Version Name(Debug)",
            new VersionsImpl(
                new ConstSource<String[]>(new String[0]),
                new ConstSource<String[]>(new String[0]),
                new ConstSource<Version>(
                    new DebugVersion(
                        new ConstSource<String>("Version Name")
                    )
                )
            ).byFlavor("SampleFlavor").versionName()
        )
    }

    void testDefaultVersionCode() {
        assertEquals(
            1,
            new VersionsImpl(
                new ConstSource<String[]>(new String[0]),
                new ConstSource<String[]>(new String[0]),
                new ConstSource<Version>(
                    new DebugVersion()
                )
            ).byFlavor("SampleFlavor").versionCode()
        )
    }

    void testDefaultVersionFlavor() {
        assertEquals(
            "Debug",
            new VersionsImpl(
                new ConstSource<String[]>(new String[0]),
                new ConstSource<String[]>(new String[0]),
                new ConstSource<Version>(
                    new DebugVersion()
                )
            ).byFlavor("SampleFlavor").flavor()
        )
    }

    void testGitTag() {
        assertEquals(
            "FlavorName_v1.0.0",
            new VersionsImpl(
                new ConstSource<String[]>(
                    ["FlavorName_v1.0.0"].toArray(new String[1])
                ),
                new ConstSource<String[]>(
                    ["FlavorName_v1.0.0"].toArray(new String[1])
                ),
                new ConstSource<Version>(
                    new DebugVersion(
                        new ConstSource<String>("DefaultName")
                    )
                )
            ).byFlavor("FlavorName").gitTag()
        )
    }

    void testVersionName() {
        assertEquals(
            "1.0.0",
            new VersionsImpl(
                new ConstSource<String[]>(
                    ["FlavorName_v1.0.0"].toArray(new String[1])
                ),
                new ConstSource<String[]>(
                    ["FlavorName_v1.0.0"].toArray(new String[1])
                ),
                new ConstSource<Version>(
                    new DebugVersion(
                        new ConstSource<String>("DefaultName")
                    )
                )
            ).byFlavor("FlavorName").versionName()
        )
    }

    void testVersionNameNotAtHead() {
        assertEquals(
            "1.0.0(Debug)",
            new VersionsImpl(
                new ConstSource<String[]>([""].toArray(new String[1])),
                new ConstSource<String[]>(["FlavorName_v1.0.0"].toArray(new String[1])),
                new ConstSource<Version>(
                    new DebugVersion(
                        new ConstSource<String>("DefaultName")
                    )
                )
            ).byFlavor("FlavorName").versionName()
        )
    }

    void testFlavor() {
        assertEquals(
            "FlavorName",
            new VersionsImpl(
                new ConstSource<String[]>(
                    ["FlavorName_v1.0.0"].toArray(new String[1])
                ),
                new ConstSource<String[]>(
                    ["FlavorName_v1.0.0"].toArray(new String[1])
                ),
                new ConstSource<Version>(
                    new DebugVersion(
                        new ConstSource<String>("DefaultName")
                    )
                )
            ).byFlavor("FlavorName").flavor()
        )
    }

    void testVersionCode() {
        assertEquals(
            10000,
            new VersionsImpl(
                new ConstSource<String[]>(
                    ["FlavorName_v1.0.0"].toArray(new String[1])
                ),
                new ConstSource<String[]>(
                    ["FlavorName_v1.0.0"].toArray(new String[1])
                ),
                new ConstSource<Version>(
                    new DebugVersion(
                        new ConstSource<String>("DefaultName")
                    )
                )
            ).byFlavor("FlavorName").versionCode()
        )
    }

    void testEmptyFlavorFound() {
        assertEquals(
            10000,
            new VersionsImpl(
                new ConstSource<String[]>(
                    ["v1.0.0"].toArray(new String[1])
                ),
                new ConstSource<String[]>(
                    ["v1.0.0"].toArray(new String[1])
                ),
                new ConstSource<Version>(
                    new DebugVersion(
                        new ConstSource<String>("DefaultName")
                    )
                )
            ).byFlavor("").versionCode()
        )
    }

    /**
     * If tag not found by empty flavor name, use the default one.
     */
    void testEmptyFlavorNotFoundVersionCode() {
        assertEquals(
            1,
            new VersionsImpl(
                new ConstSource<String[]>(
                    ["sampleFlavor_v1.0.0"].toArray(new String[1])
                ),
                new ConstSource<String[]>(
                    ["sampleFlavor_v1.0.0"].toArray(new String[1])
                ),
                new ConstSource<Version>(
                    new DebugVersion(
                        new ConstSource<String>("DefaultName")
                    )
                )
            ).byFlavor("").versionCode()
        )
    }

    void testEmptyFlavorNotFoundVersionName() {
        assertEquals(
            "DefaultName(Debug)",
            new VersionsImpl(
                new ConstSource<String[]>(
                    ["sampleFlavor_v1.0.0"].toArray(new String[1])
                ),
                new ConstSource<String[]>(
                    ["sampleFlavor_v1.0.0"].toArray(new String[1])
                ),
                new ConstSource<Version>(
                    new DebugVersion(
                        new ConstSource<String>("DefaultName")
                    )
                )
            ).version().versionName()
        )
    }

    void testTheNonExistHeadTag() {
        Version version = new VersionsImpl(
            new ConstSource<String[]>(
                ["v1.0.1"].toArray(new String[1])
            ),
            new ConstSource<String[]>(
                ["v1.0.0"].toArray(new String[1])
            ),
            new ConstSource<Version>(
                new DebugVersion(
                    new ConstSource<String>("DefaultName")
                )
            )
        ).byFlavor("")
        assertEquals("1.0.0(Debug)", version.versionName())
        assertEquals(1, version.versionCode())
    }
}
