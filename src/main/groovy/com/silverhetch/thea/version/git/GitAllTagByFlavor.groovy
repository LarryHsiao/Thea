package com.silverhetch.thea.version.git

import com.silverhetch.clotho.Source

/**
 * Source for all tag by flavor sorted by name.
 */
class GitAllTagByFlavor implements Source<String[]> {
    private final String flavor;

    GitAllTagByFlavor(String flavor) {
        this.flavor = flavor
    }

    @Override
    String[] fetch() {
        def proc = "git tag -l ${flavor}*v* --sort=-v:refname".execute()
        return proc.text.split('\n')
    }
}
