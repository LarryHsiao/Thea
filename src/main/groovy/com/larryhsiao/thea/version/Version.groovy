package com.larryhsiao.thea.version

interface Version {
    /**
     * The tag name parse from git history.
     */
    String tag()

    /**
     * The version name without flavor. e.g v1.0.0
     */
    String name()

    /**
     * Flavor name
     */
    String flavor()

    /**
     * The version code
     */
    int code()
}