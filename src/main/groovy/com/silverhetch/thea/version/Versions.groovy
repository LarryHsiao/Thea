package com.silverhetch.thea.version

/**
 * The tags at HEAD
 */
interface Versions {

    /**
     * @param flavor The flavor name, or the versionByFlavor prefix.
     * @return The first versionByFlavor we can find with the flavor.
     */
    Version versionByFlavor(String flavor)
}