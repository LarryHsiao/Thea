package com.silverhetch.thea.version

import com.silverhetch.clotho.source.ConstSource

class VersionsImplTest extends GroovyTestCase {
    void testDefaultTag() {
        assertEquals(
                "Version Name",
                new VersionsImpl(
                        new ConstSource<String[]>(
                                new String[0]
                        ),
                        new ConstSource<Version>(
                                new DebugVersion(
                                        new ConstSource<String>("Version Name")
                                )
                        )
                ).versionByFlavor("SampleFlavor").gitTag()
        )
    }

    void testDefaultVersionName() {
        assertEquals(
                "Version Name",
                new VersionsImpl(
                        new ConstSource<String[]>(
                                new String[0]
                        ),
                        new ConstSource<Version>(
                                new DebugVersion(
                                        new ConstSource<String>("Version Name")
                                )
                        )
                ).versionByFlavor("SampleFlavor").versionName()
        )
    }

    void testDefaultVersionCode() {
        assertEquals(
                1,
                new VersionsImpl(
                        new ConstSource<String[]>(
                                new String[0]
                        ),
                        new ConstSource<Version>(
                                new DebugVersion()
                        )
                ).versionByFlavor("SampleFlavor").versionCode()
        )
    }

    void testDefaultVersionFlavor() {
        assertEquals(
                "",
                new VersionsImpl(
                        new ConstSource<String[]>(
                                new String[0]
                        ),
                        new ConstSource<Version>(
                                new DebugVersion()
                        )
                ).versionByFlavor("SampleFlavor").flavor()
        )
    }

    void testGitTag() {
        assertEquals(
                "FlavorName_v1.0.0",
                new VersionsImpl(
                        new ConstSource<String[]>(
                                ["FlavorName_v1.0.0"].toArray(new String[1])
                        ),
                        new ConstSource<Version>(
                                new DebugVersion(
                                        new ConstSource<String>("DefaultName")
                                )
                        )
                ).versionByFlavor("FlavorName").gitTag()
        )
    }

    void testVersionName() {
        assertEquals(
                "v1.0.0",
                new VersionsImpl(
                        new ConstSource<String[]>(
                                ["FlavorName_v1.0.0"].toArray(new String[1])
                        ),
                        new ConstSource<Version>(
                                new DebugVersion(
                                        new ConstSource<String>("DefaultName")
                                )
                        )
                ).versionByFlavor("FlavorName").versionName()
        )
    }

    void testFlavor() {
        assertEquals(
                "FlavorName",
                new VersionsImpl(
                        new ConstSource<String[]>(
                                ["FlavorName_v1.0.0"].toArray(new String[1])
                        ),
                        new ConstSource<Version>(
                                new DebugVersion(
                                        new ConstSource<String>("DefaultName")
                                )
                        )
                ).versionByFlavor("FlavorName").flavor()
        )
    }

    void testVersionCode() {
        assertEquals(
                10000,
                new VersionsImpl(
                        new ConstSource<String[]>(
                                ["FlavorName_v1.0.0"].toArray(new String[1])
                        ),
                        new ConstSource<Version>(
                                new DebugVersion(
                                        new ConstSource<String>("DefaultName")
                                )
                        )
                ).versionByFlavor("FlavorName").versionCode()
        )
    }
}
