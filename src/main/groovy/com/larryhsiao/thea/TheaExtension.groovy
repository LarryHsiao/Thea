package com.larryhsiao.thea

import com.larryhsiao.clotho.source.ConstSource
import com.larryhsiao.thea.version.*
import com.larryhsiao.thea.version.git.GitAllTagByFlavor
import com.larryhsiao.thea.version.git.GitHeadTagSource

import java.util.function.Function

class TheaExtension {
    public final Versions version = new VersionsImpl(
            new GitHeadTagSource(),
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
                    new GitHeadTagSource(),
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
                    new GitHeadTagSource(),
                    new GitAllTagByFlavor(),
                    new ConstSource<Version>(
                            new DebugVersion()
                    ), flavor
            ).value()
        }
    }
}
