package com.silverhetch.thea

import com.silverhetch.thea.version.GitHeadTagSource


class GitHeadVersionSourceTest extends GroovyTestCase {
    void testAvailable() {
        assertNotNull(new GitHeadTagSource().fetch())
    }
}
