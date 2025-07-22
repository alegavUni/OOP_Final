package com.github.alegavuni.matte1cat.javabenchmarks.utils.hashing;

import java.util.UUID;

public class LocationKeyWithUUID {
    private final long most;
    private final long least;
    private final int x;
    private final short y;
    private final int z;

    public LocationKeyWithUUID(UUID uuid, int x, int y, int z) {
        this.most = uuid.getMostSignificantBits();
        this.least = uuid.getLeastSignificantBits();
        this.x = x;
        this.y = (short) y;
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof LocationKeyWithUUID other)) return false;
        return most == other.most && least == other.least && x == other.x && y == other.y && z == other.z;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash = 19 * hash + Long.hashCode(most);
        hash = 19 * hash + Long.hashCode(least);
        hash = 19 * hash + this.x;
        hash = 19 * hash + this.y;
        hash = 19 * hash + this.z;
        return hash;
    }
}
