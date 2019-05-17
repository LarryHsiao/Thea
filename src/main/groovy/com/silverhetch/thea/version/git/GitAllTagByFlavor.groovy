package com.silverhetch.thea.version.git

import com.silverhetch.clotho.Source

/**
 * Source for all tag by flavor sorted by name.
 */
class GitAllTagByFlavor implements Source<String[]> {

    @Override
    String[] value() {
        def proc = "git tag -l --sort=-v:refname --merged".execute()
        return proc.text.split('\n')
    }
}
