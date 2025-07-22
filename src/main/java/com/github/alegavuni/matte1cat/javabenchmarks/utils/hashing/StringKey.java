package com.github.alegavuni.matte1cat.javabenchmarks.utils.hashing;

import java.util.UUID;

public class StringKey {
    private final String key;

    public StringKey(int x, int y, int z, UUID worldUuid) {
        this.key = x + ";" + y + ";" + z + ";" + worldUuid;
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof StringKey other) && key.equals(other.key);
    }

    @Override
    public int hashCode() {
        return key.hashCode();
    }
}
