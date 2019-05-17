package com.silverhetch.thea

import com.silverhetch.thea.version.git.GitHeadTagSource


class GitHeadVersionSourceTest extends GroovyTestCase {
    void testAvailable() {
        assertNotNull(new GitHeadTagSource().value())
    }
}
