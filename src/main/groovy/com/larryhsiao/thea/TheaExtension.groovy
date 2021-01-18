package com.larryhsiao.thea

import com.larryhsiao.clotho.Source
import com.larryhsiao.clotho.source.ConstSource
import com.larryhsiao.thea.version.*
import com.larryhsiao.thea.version.git.GitAllTagByFlavor
import com.larryhsiao.thea.version.git.GitHeadTagSource

class TheaExtension implements Versions {
    private final Source<String[]> gitHeads;
    private final Source<String[]> gitAllTags;

    TheaExtension(){
        this(new GitHeadTagSource(), new GitAllTagByFlavor())
    }

    TheaExtension(Source<String[]> gitHeads, Source<String[]> gitAllTags) {
        this.gitHeads = gitHeads
        this.gitAllTags = gitAllTags
    }

    private final Versions version = new VersionsImpl(
        gitHeads,
        gitAllTags,
        new ConstSource<Version>(
            new DebugVersion()
        )
    )

    @Override
    Version byFlavor(String flavor) {
        return version.byFlavor(flavor)
    }

    @Override
    Version version() {
        return version.version()
    }

    /**
     * @return A fixed format version indicator.
     */
    String versionIndicator(String flavor) {
        return new VersionString(
            new GitHeadTagSource(),
            new GitAllTagByFlavor(),
            new ConstSource<Version>(
                new DebugVersion()
            ),
            flavor
        ).value()
    }
}
