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
    public final Function<String, Versions> version = new Function<String, Versions>() {
        @Override
        Versions apply(String flavor) {
            return new VersionsImpl(
                    new GitAllTagByFlavor(flavor),
                    new ConstSource<Version>(
                            new DebugVersion()
                    )
            )
        }
    }

    public final Function<String, String> versionIndicator = new Function<String, String>() {
        @Override
        String apply(String flavor) {
            return new VersionString(
                    new GitAllTagByFlavor(flavor),
                    new ConstSource<Version>(
                            new DebugVersion()
                    ), flavor
            ).fetch()
        }
    }
}
