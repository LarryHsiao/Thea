Thea
-----

A Gradle plugin that versioning project with Git tag.
We use git tags for versioning, but it is not as same as the version we have actually put in the source code.
This is a plugin which may keep us out of the trouble like that.

[![We recommend IntelliJ IDEA](http://www.elegantobjects.org/intellij-idea.svg)](https://www.jetbrains.com/idea/)

[![](https://silverhetch.com:9082/app/rest/builds/buildType:Thea_Build/statusIcon.svg)](https://github.com/LarryHsiao/thea)
[![Build Status](https://travis-ci.org/LarryHsiao/Thea.svg?branch=master)](https://travis-ci.org/LarryHsiao/Thea)
[![License: MIT](https://img.shields.io/badge/License-MIT-green.svg)](https://opensource.org/licenses/MIT)

#### Capability
- Identifies Version with Sequence-based identifiers(3 numbers) major, minor, patch (e.g. xx.xx.xx)
  - Each number is less then 100
  - Supports flavor prefix (e.g. flavorName_v1.0.0) 
- Generates version indicators
  - Version name: (tag)v1.0.0 -> (output)1.0.0
  - Version code: integer which calculated with version name. (tag)v1.0.0 -> (output)10000

#### Example


#### Apply plugin

```groovy
// For dependencies
buildscript {
    repositories {
        maven { url = 'http://172.104.79.181:81/repository/Elizabeth/' }
    }
}

plugins {
    id 'com.silverhetch.thea' version '1.1.3'
}
```

#### Usage
```groovy
// To print the version info with given flavor, empty to find tag which has no flavor prefix.
System.out.println(thea.versionIndicator.apply(""))

// To apply to java project, here is a sample
group 'com.silverhetch'
version thea.version.versionByFlavor("").versionName()
```