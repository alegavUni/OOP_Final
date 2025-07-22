package com.github.alegavuni.matte1cat.javabenchmarks.utils.hashing;

import java.util.UUID;

public class LocationKeyWithUUID_Fastest {
    private final long most;
    private final long least;
    private final int x;
    private final short y;
    private final int z;

    public LocationKeyWithUUID_Fastest(UUID uuid, int x, int y, int z) {
        this.most = uuid.getMostSignificantBits();
        this.least = uuid.getLeastSignificantBits();
        this.x = x;
        this.y = (short) y;
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof LocationKeyWithUUID_Fastest other)) return false;
        return most == other.most && least == other.least && x == other.x && y == other.y && z == other.z;
    }

    @Override
    public int hashCode() {
        int h = Long.hashCode(most);
        h ^= Long.hashCode(least);
        h ^= x * 0x9E3779B9; // golden ratio prime
        h ^= (y & 0xFFFF) * 0x85EBCA6B;
        h ^= z * 0xC2B2AE35;
        return h;
    }
}
