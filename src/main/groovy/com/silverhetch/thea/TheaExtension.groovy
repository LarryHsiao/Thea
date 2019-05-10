package com.silverhetch.thea


import com.silverhetch.clotho.source.ConstSource
import com.silverhetch.thea.version.DebugVersion
import com.silverhetch.thea.version.git.GitAllTagByFlavor
import com.silverhetch.thea.version.Version
import com.silverhetch.thea.version.VersionString
import com.silverhetch.thea.version.Versions
import com.silverhetch.thea.version.VersionsImpl

import java.util.function.Function

class TheaExtension {
    public final Versions version = new VersionsImpl(
            new GitAllTagByFlavor(),
            new ConstSource<Version>(
                    new DebugVersion()
            )
    )

    @Deprecated
    public final Function<String, String> versionIndicator = new Function<String, String>() {
        @Override
        String apply(String flavor) {
            return new VersionString(
                    new GitAllTagByFlavor(),
                    new ConstSource<Version>(
                            new DebugVersion()
                    ), flavor
            ).fetch()
        }
    }

    public final Function<String, String> indicator = new Function<String, String>() {
        @Override
        String apply(String flavor) {
            return new VersionString(
                    new GitAllTagByFlavor(),
                    new ConstSource<Version>(
                            new DebugVersion()
                    ), flavor
            ).fetch()
        }
    }
}
