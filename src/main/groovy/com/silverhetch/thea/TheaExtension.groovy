package com.silverhetch.thea

import com.silverhetch.clotho.source.ConstSource
import com.silverhetch.thea.version.DebugVersion
import com.silverhetch.thea.version.GitHeadTagSource
import com.silverhetch.thea.version.Version
import com.silverhetch.thea.version.Versions
import com.silverhetch.thea.version.VersionsImpl

class TheaExtension {
    private String[] validFlavor = new String[0]

    String[] getValidFlavor() {
        return validFlavor
    }

    void setValidFlavor(String[] validFlavor) {
        this.validFlavor = validFlavor
    }
}
