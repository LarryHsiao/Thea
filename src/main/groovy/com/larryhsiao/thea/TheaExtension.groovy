package com.larryhsiao.thea


import com.silverhetch.clotho.source.ConstSource
import com.larryhsiao.thea.version.DebugVersion
import com.larryhsiao.thea.version.git.GitAllTagByFlavor
import com.larryhsiao.thea.version.Version
import com.larryhsiao.thea.version.VersionString
import com.larryhsiao.thea.version.Versions
import com.larryhsiao.thea.version.VersionsImpl

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
            ).value()
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
            ).value()
        }
    }
}
