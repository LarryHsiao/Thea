package com.silverhetch.thea

import com.silverhetch.clotho.Source
import com.silverhetch.clotho.source.ConstSource
import com.silverhetch.thea.version.DebugVersion
import com.silverhetch.thea.version.GitHeadTagSource
import com.silverhetch.thea.version.Version
import com.silverhetch.thea.version.VersionString
import com.silverhetch.thea.version.Versions
import com.silverhetch.thea.version.VersionsImpl

import java.util.function.Function

class TheaExtension {
    public final Versions version = new VersionsImpl(
            new GitHeadTagSource(),
            new ConstSource<Version>(
                    new DebugVersion()
            )
    )

    public final Function<String, String> versionIndicator = new Function<String, String>() {
        @Override
        String apply(String flavor) {
            return new VersionString(
                    new GitHeadTagSource(),
                    new ConstSource<Version>(
                            new DebugVersion()
                    ), flavor
            ).fetch()
        }
    }
}
