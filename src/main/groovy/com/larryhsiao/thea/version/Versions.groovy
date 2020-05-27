package com.larryhsiao.thea.version

/**
 * The tags at HEAD
 */
interface Versions {

    /**
     * @param flavor The flavor name, or the byFlavor prefix.
     * @return The first byFlavor we can find with the flavor.
     */
    Version byFlavor(String flavor)

    /**
     * @return The version object without flavor.
     */
    Version version()
}