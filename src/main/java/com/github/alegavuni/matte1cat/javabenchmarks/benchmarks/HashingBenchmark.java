/**
 * Results depend on hardware and JVM; consider them as a reference only.
 * Benchmarking results on a Ryzen 7 9700X, DDR5 RAM:
 * Benchmark                                 (size)  Mode  Cnt   Score   Error  Units
 * HashingBenchmark.testBlockKey                  1  avgt    3   3,036 ± 0,210  ns/op
 * HashingBenchmark.testBlockKey                  3  avgt    3   3,045 ± 0,265  ns/op
 * HashingBenchmark.testBlockKey                  5  avgt    3   3,038 ± 0,062  ns/op
 * HashingBenchmark.testBlockKey                  8  avgt    3   3,044 ± 0,320  ns/op
 * HashingBenchmark.testBlockKey                 10  avgt    3   3,034 ± 0,121  ns/op
 * HashingBenchmark.testBlockKey                100  avgt    3   3,423 ± 0,129  ns/op
 * HashingBenchmark.testBlockKey               1000  avgt    3   2,983 ± 0,157  ns/op
 * HashingBenchmark.testBlockKey              10000  avgt    3   2,991 ± 0,148  ns/op
 * HashingBenchmark.testStringKey                 1  avgt    3  53,421 ± 1,797  ns/op
 * HashingBenchmark.testStringKey                 3  avgt    3  50,110 ± 2,780  ns/op
 * HashingBenchmark.testStringKey                 5  avgt    3  50,729 ± 1,255  ns/op
 * HashingBenchmark.testStringKey                 8  avgt    3  53,704 ± 6,687  ns/op
 * HashingBenchmark.testStringKey                10  avgt    3  52,201 ± 4,391  ns/op
 * HashingBenchmark.testStringKey               100  avgt    3  52,400 ± 1,662  ns/op
 * HashingBenchmark.testStringKey              1000  avgt    3  52,583 ± 3,524  ns/op
 * HashingBenchmark.testStringKey             10000  avgt    3  49,726 ± 2,294  ns/op
 * HashingBenchmark.testUUIDKey                   1  avgt    3   3,703 ± 0,099  ns/op
 * HashingBenchmark.testUUIDKey                   3  avgt    3   4,199 ± 0,817  ns/op
 * HashingBenchmark.testUUIDKey                   5  avgt    3   3,689 ± 0,083  ns/op
 * HashingBenchmark.testUUIDKey                   8  avgt    3   3,682 ± 0,097  ns/op
 * HashingBenchmark.testUUIDKey                  10  avgt    3   3,688 ± 0,098  ns/op
 * HashingBenchmark.testUUIDKey                 100  avgt    3   3,709 ± 0,178  ns/op
 * HashingBenchmark.testUUIDKey                1000  avgt    3   3,692 ± 0,260  ns/op
 * HashingBenchmark.testUUIDKey               10000  avgt    3   3,702 ± 0,146  ns/op
 * HashingBenchmark.testUUIDKey_Fastest           1  avgt    3   3,471 ± 0,154  ns/op
 * HashingBenchmark.testUUIDKey_Fastest           3  avgt    3   4,083 ± 0,154  ns/op
 * HashingBenchmark.testUUIDKey_Fastest           5  avgt    3   3,463 ± 0,148  ns/op
 * HashingBenchmark.testUUIDKey_Fastest           8  avgt    3   4,452 ± 0,153  ns/op
 * HashingBenchmark.testUUIDKey_Fastest          10  avgt    3   3,476 ± 0,077  ns/op
 * HashingBenchmark.testUUIDKey_Fastest         100  avgt    3   3,458 ± 0,083  ns/op
 * HashingBenchmark.testUUIDKey_Fastest        1000  avgt    3   3,471 ± 0,051  ns/op
 * HashingBenchmark.testUUIDKey_Fastest       10000  avgt    3   3,507 ± 0,216  ns/op
 * HashingBenchmark.testUUIDKey_ObjectsHash       1  avgt    3  14,509 ± 0,990  ns/op
 * HashingBenchmark.testUUIDKey_ObjectsHash       3  avgt    3  14,637 ± 0,519  ns/op
 * HashingBenchmark.testUUIDKey_ObjectsHash       5  avgt    3  14,705 ± 4,487  ns/op
 * HashingBenchmark.testUUIDKey_ObjectsHash       8  avgt    3  14,572 ± 0,777  ns/op
 * HashingBenchmark.testUUIDKey_ObjectsHash      10  avgt    3  15,022 ± 0,684  ns/op
 * HashingBenchmark.testUUIDKey_ObjectsHash     100  avgt    3  14,385 ± 0,555  ns/op
 * HashingBenchmark.testUUIDKey_ObjectsHash    1000  avgt    3  14,475 ± 0,162  ns/op
 * HashingBenchmark.testUUIDKey_ObjectsHash   10000  avgt    3  15,433 ± 0,629  ns/op
 * <p>
 * Considerations:
 *   - BlockKey (128-bit key) hashing is very fast (~3 ns per operation) but not really possible.
 *   - UUID-based keys hashing ranges around ~3.5 to 4 ns for optimized versions.
 *   - String keys are much slower (~50 ns per operation).
 *   - Using Objects.hash() for UUID (Objects generally) keys is slower (~14-15 ns).
 * Specific hashCode implementations improve performance significantly over default Java or naive hashing.
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
