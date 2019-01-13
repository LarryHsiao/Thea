package com.silverhetch.thea.version

import com.silverhetch.clotho.Source

/**
 * Source which fetch tags current HEAD have.
 */
class GitHeadTagSource implements Source<String[]> {
    @Override
    String[] fetch() {
        return getCurrentGitTag()
    }

    /**
     * Obtain current versionByFlavor on git log tree.
     */
    static def getCurrentGitTag = { ->
        def sout = new StringBuilder()
        def serr = new StringBuilder()

        def proc = 'git versionByFlavor --points-at HEAD'.execute()
        proc.consumeProcessOutput(sout, serr)
        return sout.toString()
    }
}
