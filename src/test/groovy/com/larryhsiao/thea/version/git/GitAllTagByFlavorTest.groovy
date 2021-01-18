package com.larryhsiao.thea.version.git
/**
 * Test for {@link GitAllTagByFlavor}.
 */
class GitAllTagByFlavorTest extends GroovyTestCase {
    void testHasTag() {
        assertTrue(
            new GitAllTagByFlavor().value().length > 0
        )
    }
}
