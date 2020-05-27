package com.larryhsiao.thea.version.git

class GitHeadVersionSourceTest extends GroovyTestCase {
    void testAvailable() {
        assertNotNull(new GitHeadTagSource().value())
    }
}
