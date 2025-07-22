package com.github.alegavuni.matte1cat.javabenchmarks.utils.hashing;

public class BlockKey128 {
    private final long hi;
    private final long lo;

    public BlockKey128(int x, int y, int z, int worldId) {
        long hx = ((long) x) & 0xFFFFFFFFL;
        long hy = ((long) y) & 0xFFFFL;
        this.hi = (hx << 32) | hy;

        long hz = ((long) z) & 0xFFFFFFFFL;
        long hw = ((long) worldId) & 0xFFL;
        this.lo = (hz << 32) | hw;
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof BlockKey128 other) && this.hi == other.hi && this.lo == other.lo;
    }

    @Override
    public int hashCode() {
        return (int) (hi ^ (hi >>> 32) ^ lo ^ (lo >>> 32));
    }
}
