Thea
-----
A Gradle plugin that fetch version name from git tag. Make our life a little bit easier.

[![We recommend IntelliJ IDEA](http://www.elegantobjects.org/intellij-idea.svg)](https://www.jetbrains.com/idea/)

[![PDD status](http://www.0pdd.com/svg?name=LarryHsiao/thea)](http://www.0pdd.com/p?name=LarryHsiao/thea)

[![](https://img.shields.io/github/tag/LarryHsiao/Thea.svg)](https://github.com/LarryHsiao/Thea/tags)
[![](https://silverhetch.com:9082/app/rest/builds/buildType:Thea_Build/statusIcon.svg)](https://github.com/LarryHsiao/thea)
[![Build Status](https://travis-ci.org/LarryHsiao/Thea.svg?branch=master)](https://travis-ci.org/LarryHsiao/Thea)
[![codecov](https://codecov.io/gh/LarryHsiao/Thea/branch/master/graph/badge.svg)](https://codecov.io/gh/LarryHsiao/Thea)
[![License: MIT](https://img.shields.io/badge/License-MIT-green.svg)](https://opensource.org/licenses/MIT)

#### Capability
- Identifies Version with Sequence-based identifiers(3 numbers) major, minor, patch (e.g. xx.xx.xx)
  - Each number is less then 100
  - Supports flavor prefix (e.g. flavorName_v1.0.0) 
- Generates version indicators
  - Version name: (tag)v1.0.0 -> (output)1.0.0
  - Version code: integer which calculated with version name. (tag)v1.0.0 -> (output)10000

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

#### Print Version in Gradle output

Add the following line to Build.Gradle or anywhere you want to apply.
The current version shows up every time we do gradle sync.

```groovy
println(thea.versionIndicator.apply(""))
```

###### Output Example

```
Version---------------------
tag: 201903102330
name: 201903102330(Debug)
code: 1
============================
```

#### Use case examples

###### v1.0.0
```groovy
def versionName = thea.version.versionByFlavor("").versionName()
def versionCode = thea.version.versionByFlavor("").versionCode()

// versionName = 1.0.0
// versionCode = 10000

```

###### FlavorName_v1.0.0

```groovy
def versionName = thea.version.versionByFlavor("FlavorName").versionName() // 1.0.0
def versionCode = thea.version.versionByFlavor("FlavorName").versionCode() // 10000

// versionName = 1.0.0
// versionCode = 10000

```

###### FlavorName_v1.0.0

```groovy
def versionName = thea.version.versionByFlavor("FlavorNameNotMatched").versionName() 
def versionCode = thea.version.versionByFlavor("FlavorNameNotMatched").versionCode() 

// versionName = 201901151200(Debug)
// versioncode = 1

```
