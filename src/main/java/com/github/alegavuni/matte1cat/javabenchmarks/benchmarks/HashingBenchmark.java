/**
 * Benchmarking results on a Ryzen 7 9700X, DDR5 RAM:
 * Benchmark                                  (size)  Mode  Cnt   Score   Error  Units
 * HashingBenchmarks.testBlockKey                 10  avgt    3   2,987 ± 0,054  ns/op
 * HashingBenchmarks.testBlockKey                100  avgt    3   3,425 ± 0,176  ns/op
 * HashingBenchmarks.testBlockKey               1000  avgt    3   2,986 ± 0,188  ns/op
 * HashingBenchmarks.testBlockKey              10000  avgt    3   3,009 ± 0,067  ns/op
 * HashingBenchmarks.testStringKey                10  avgt    3  52,488 ± 2,552  ns/op
 * HashingBenchmarks.testStringKey               100  avgt    3  52,568 ± 3,480  ns/op
 * HashingBenchmarks.testStringKey              1000  avgt    3  52,496 ± 4,038  ns/op
 * HashingBenchmarks.testStringKey             10000  avgt    3  49,989 ± 1,619  ns/op
 * HashingBenchmarks.testUUIDKey                  10  avgt    3   3,702 ± 0,687  ns/op
 * HashingBenchmarks.testUUIDKey                 100  avgt    3   3,676 ± 0,123  ns/op
 * HashingBenchmarks.testUUIDKey                1000  avgt    3   3,711 ± 0,008  ns/op
 * HashingBenchmarks.testUUIDKey               10000  avgt    3   4,179 ± 0,174  ns/op
 * HashingBenchmarks.testUUIDKey_Fastest          10  avgt    3   3,460 ± 0,048  ns/op
 * HashingBenchmarks.testUUIDKey_Fastest         100  avgt    3   3,472 ± 0,106  ns/op
 * HashingBenchmarks.testUUIDKey_Fastest        1000  avgt    3   3,520 ± 0,125  ns/op
 * HashingBenchmarks.testUUIDKey_Fastest       10000  avgt    3   3,486 ± 0,151  ns/op
 * HashingBenchmarks.testUUIDKey_ObjectsHash      10  avgt    3  14,528 ± 0,913  ns/op
 * HashingBenchmarks.testUUIDKey_ObjectsHash     100  avgt    3  14,424 ± 0,569  ns/op
 * HashingBenchmarks.testUUIDKey_ObjectsHash    1000  avgt    3  14,585 ± 0,405  ns/op
 * HashingBenchmarks.testUUIDKey_ObjectsHash   10000  avgt    3  14,368 ± 0,555  ns/op
 * <p>
 * Considerations:
 */

package com.github.alegavuni.matte1cat.javabenchmarks.benchmarks;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.*;
import com.github.alegavuni.matte1cat.javabenchmarks.utils.hashing.*;

@State(Scope.Thread)
public class HashingBenchmark {

    private static final UUID WORLD_UUID = UUID.randomUUID();
    private static final int WORLD_ID = 42;

    private final Map<StringKey, Integer> stringMap = new HashMap<>();
    private final Map<BlockKey128, Integer> blockMap = new HashMap<>();
    private final Map<LocationKeyWithUUID, Integer> uuidMap = new HashMap<>();
    private final Map<LocationKeyWithUUID_Fastest, Integer> uuidUtilMap = new HashMap<>();
    private final Map<LocationKeyWithUUID_ObjectsHash, Integer> uuidObjectsMap = new HashMap<>();

    @Param({"1", "3", "5", "8", "10", "100", "1000", "10000"})
    public int size;

    public int index;

    private int[] xs;
    private int[] ys;
    private int[] zs;

    @Setup(Level.Trial)
    public void setup() {
        xs = new int[size];
        ys = new int[size];
        zs = new int[size];

        Random random = new Random(1234);
        for (int i = 0; i < size; i++) {
            xs[i] = random.nextInt(60_000_000) - 30_000_000;
            ys[i] = random.nextInt(450);
            zs[i] = random.nextInt(60_000_000) - 30_000_000;
        }

        for (int i = 0; i < size; i++) {
            stringMap.put(new StringKey(xs[i], ys[i], zs[i], WORLD_UUID), i);
            blockMap.put(new BlockKey128(xs[i], ys[i], zs[i], WORLD_ID), i);
            uuidMap.put(new LocationKeyWithUUID(WORLD_UUID, xs[i], ys[i], zs[i]), i);
            uuidUtilMap.put(new LocationKeyWithUUID_Fastest(WORLD_UUID, xs[i], ys[i], zs[i]), i);
            uuidObjectsMap.put(new LocationKeyWithUUID_ObjectsHash(WORLD_UUID, xs[i], ys[i], zs[i]), i);
        }

        index = size / 2;
    }

    @Benchmark
    public void testStringKey(Blackhole bh) {
        StringKey key = new StringKey(xs[index], ys[index], zs[index], WORLD_UUID);
        bh.consume(stringMap.get(key));
    }

    @Benchmark
    public void testBlockKey(Blackhole bh) {
        BlockKey128 key = new BlockKey128(xs[index], ys[index], zs[index], WORLD_ID);
        bh.consume(blockMap.get(key));
    }

    @Benchmark
    public void testUUIDKey(Blackhole bh) {
        LocationKeyWithUUID key = new LocationKeyWithUUID(WORLD_UUID, xs[index], ys[index], zs[index]);
        bh.consume(uuidMap.get(key));
    }

    @Benchmark
    public void testUUIDKey_Fastest(Blackhole bh) {
        LocationKeyWithUUID_Fastest key = new LocationKeyWithUUID_Fastest(WORLD_UUID, xs[index], ys[index], zs[index]);
        bh.consume(uuidUtilMap.get(key));
    }

    @Benchmark
    public void testUUIDKey_ObjectsHash(Blackhole bh) {
        LocationKeyWithUUID_ObjectsHash key = new LocationKeyWithUUID_ObjectsHash(WORLD_UUID, xs[index], ys[index], zs[index]);
        bh.consume(uuidObjectsMap.get(key));
    }

}
