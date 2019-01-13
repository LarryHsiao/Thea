package com.silverhetch.thea

import com.silverhetch.clotho.source.ConstSource
import com.silverhetch.thea.version.DebugVersion
import com.silverhetch.thea.version.GitHeadTagSource
import com.silverhetch.thea.version.Version
import com.silverhetch.thea.version.Versions
import com.silverhetch.thea.version.VersionsImpl

class TheaExtension {
    private final Versions versions = new VersionsImpl(
            new GitHeadTagSource(),
            new ConstSource<Version>(new DebugVersion())
    )

    def versionName = { String flavor ->
        return versions.versionByFlavor(flavor).versionName()
    }

    def versionCode = { String flavor ->
        return versions.versionByFlavor(flavor).versionCode()
    }
}
