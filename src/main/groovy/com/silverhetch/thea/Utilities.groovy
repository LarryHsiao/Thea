package com.silverhetch.thea

class Utilities {
    /**
     * Obtain current tag on git log tree.
     */
    def getCurrentGitTag = { ->
        def stdout = new ByteArrayOutputStream()
        exec {
            commandLine 'git', 'tag', '--points-at', 'HEAD'
            standardOutput = stdout
        }
        return stdout.toString()
    }

    def versionWithTime = {
        def date = new Date()
        def formattedDate = date.format('yyyyMMddHHmm')
        return formattedDate
    }

/**
 * Version name:
 *  - In development : Daytime
 *  - With tag       : Version in tag
 */
    def getVersionName = { flavor ->
        def result = getCurrentGitTag()
        if (result == null || result.isEmpty() || !result.toLowerCase().contains(flavor)) {
            return versionWithTime()
        } else {
            def tags = result.trim().toLowerCase().split('\n')
            tags.each { it ->
                if (it.trim().contains(flavor.toLowerCase())) {
                    return it.replaceAll("amaryllo_", "")
                            .replaceAll("soteria_", "")
                            .replaceAll("soteriaai_", "")
                            .replaceAll("globalPass_", "")
                }
            }
            throw new RuntimeException("In flavor: ${flavor}, Tag format not right or doesn`t contains flavor. ${tags}")
        }
    }


/**
 * No tag   : 1
 * With Tag : 5300000 + integer of versionName
 * v1.10.1 => 5300000 + 11001 = 5311001
 * v1.1.1  => 5300000 + 10101 = 5310101
 */
    def getVersionCode = { flavor ->
        def result = getCurrentGitTag()
        if (result == null || result.isEmpty() || !result.toLowerCase().contains(flavor)) {
            return 1
        } else {
            System.out.println(getVersionName(flavor))
            def (major, minor, patch) = getVersionName(flavor).replaceAll("v", "").split('\\.')
            return 5300000 +
                    (Integer.valueOf(major.trim()) * 10000) +
                    (Integer.valueOf(minor.trim()) * 100) +
                    Integer.valueOf(patch.trim())
        }
    }
}