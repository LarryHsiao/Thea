package com.silverhetch.thea.version.git

import com.silverhetch.clotho.Source

/**
 * Source which fetch tags current HEAD have.
 */
class GitHeadTagSource implements Source<String[]> {
    @Override
    String[] value() {
        def proc = 'git tag --points-at HEAD'.execute()
        return proc.text.split('\n')
    }
}
