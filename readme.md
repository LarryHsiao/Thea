Thea
-----

A Gradle plugin that versioning project with Git tag.

Still in progress.

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