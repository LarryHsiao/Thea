package com.silverhetch.thea.version

interface Version {

    /**
     * @return The versionByFlavor name
     */
    String gitTag()

    /**
     * The version name without flavor. e.g v1.0.0
     */
    String versionName()

    /**
     * @return Flavor name
     */
    String flavor()

    /**
     * @return The version code
     */
    int versionCode()
}