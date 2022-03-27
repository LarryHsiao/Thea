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
    public String tag() {
        return version.tag();
    }

    @Override
    public String name() {
        return version.name();
    }

    @Override
    public String flavor() {
        return version.flavor();
    }

    @Override
    public int code() {
        return version.code();
    }
}
