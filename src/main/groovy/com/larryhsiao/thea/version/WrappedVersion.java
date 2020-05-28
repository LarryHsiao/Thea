package com.larryhsiao.thea.version;

/**
 * Wrapped object of {@link Version}
 */
public class WrappedVersion implements Version {
    private final Version version;

    public WrappedVersion(Version version) {
        this.version = version;
    }

    @Override
    public String gitTag() {
        return version.gitTag();
    }

    @Override
    public String versionName() {
        return version.versionName();
    }

    @Override
    public String flavor() {
        return version.flavor();
    }

    @Override
    public int versionCode() {
        return version.versionCode();
    }
}
