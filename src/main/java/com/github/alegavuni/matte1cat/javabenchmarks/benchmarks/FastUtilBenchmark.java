/**
 * Results depend on hardware and JVM; consider them as a reference only.
 * Benchmarking results on a Ryzen 7 9700X, DDR5 RAM:
 * Benchmark                                          (size)  Mode  Cnt     Score       Error  Units
 * Benchmark                                      (size)  Mode  Cnt     Score       Error  Units
 * FastUtilBenchmark.longSetFastutilExisting           1  avgt    3     0,596 ±     0,018  ns/op
 * FastUtilBenchmark.longSetFastutilExisting           3  avgt    3     0,596 ±     0,048  ns/op
 * FastUtilBenchmark.longSetFastutilExisting           5  avgt    3     0,606 ±     0,037  ns/op
 * FastUtilBenchmark.longSetFastutilExisting           8  avgt    3     0,597 ±     0,111  ns/op
 * FastUtilBenchmark.longSetFastutilExisting          10  avgt    3     1,159 ±     0,036  ns/op
 * FastUtilBenchmark.longSetFastutilExisting         100  avgt    3     0,603 ±     0,054  ns/op
 * FastUtilBenchmark.longSetFastutilExisting        1000  avgt    3     0,606 ±     0,039  ns/op
 * FastUtilBenchmark.longSetFastutilExisting       10000  avgt    3     0,618 ±     0,883  ns/op
 * FastUtilBenchmark.longSetFastutilNonExisting        1  avgt    3     1,281 ±     0,206  ns/op
 * FastUtilBenchmark.longSetFastutilNonExisting        3  avgt    3     1,927 ±     0,043  ns/op
 * FastUtilBenchmark.longSetFastutilNonExisting        5  avgt    3     1,275 ±     0,025  ns/op
 * FastUtilBenchmark.longSetFastutilNonExisting        8  avgt    3     0,557 ±     0,047  ns/op
 * FastUtilBenchmark.longSetFastutilNonExisting       10  avgt    3     2,074 ±     0,008  ns/op
 * FastUtilBenchmark.longSetFastutilNonExisting      100  avgt    3     0,550 ±     0,004  ns/op
 * FastUtilBenchmark.longSetFastutilNonExisting     1000  avgt    3     2,439 ±     0,059  ns/op
 * FastUtilBenchmark.longSetFastutilNonExisting    10000  avgt    3     2,427 ±     0,086  ns/op
 * FastUtilBenchmark.longSetJavaExisting               1  avgt    3     1,621 ±     0,094  ns/op
 * FastUtilBenchmark.longSetJavaExisting               3  avgt    3     1,595 ±     0,084  ns/op
 * FastUtilBenchmark.longSetJavaExisting               5  avgt    3     1,595 ±     0,066  ns/op
 * FastUtilBenchmark.longSetJavaExisting               8  avgt    3     1,608 ±     0,063  ns/op
 * FastUtilBenchmark.longSetJavaExisting              10  avgt    3     2,014 ±     0,080  ns/op
 * FastUtilBenchmark.longSetJavaExisting             100  avgt    3     1,590 ±     0,093  ns/op
 * FastUtilBenchmark.longSetJavaExisting            1000  avgt    3     2,367 ±     0,042  ns/op
 * FastUtilBenchmark.longSetJavaExisting           10000  avgt    3     1,590 ±     0,034  ns/op
 * FastUtilBenchmark.longSetJavaNonExisting            1  avgt    3     1,291 ±     0,058  ns/op
 * FastUtilBenchmark.longSetJavaNonExisting            3  avgt    3     1,721 ±     0,038  ns/op
 * FastUtilBenchmark.longSetJavaNonExisting            5  avgt    3     1,713 ±     0,067  ns/op
 * FastUtilBenchmark.longSetJavaNonExisting            8  avgt    3     1,453 ±     4,635  ns/op
 * FastUtilBenchmark.longSetJavaNonExisting           10  avgt    3     1,380 ±     0,016  ns/op
 * FastUtilBenchmark.longSetJavaNonExisting          100  avgt    3     1,297 ±     0,091  ns/op
 * FastUtilBenchmark.longSetJavaNonExisting         1000  avgt    3     1,308 ±     0,045  ns/op
 * FastUtilBenchmark.longSetJavaNonExisting        10000  avgt    3     1,404 ±     0,033  ns/op
 * FastUtilBenchmark.uuidListFastutilExisting          1  avgt    3     0,462 ±     0,059  ns/op
 * FastUtilBenchmark.uuidListFastutilExisting          3  avgt    3     1,349 ±     0,015  ns/op
 * FastUtilBenchmark.uuidListFastutilExisting          5  avgt    3     1,870 ±     0,018  ns/op
 * FastUtilBenchmark.uuidListFastutilExisting          8  avgt    3     2,717 ±     0,251  ns/op
 * FastUtilBenchmark.uuidListFastutilExisting         10  avgt    3     3,562 ±     8,279  ns/op
 * FastUtilBenchmark.uuidListFastutilExisting        100  avgt    3    17,075 ±     0,326  ns/op
 * FastUtilBenchmark.uuidListFastutilExisting       1000  avgt    3   161,533 ±     3,088  ns/op
 * FastUtilBenchmark.uuidListFastutilExisting      10000  avgt    3  2559,465 ±    46,725  ns/op
 * FastUtilBenchmark.uuidListFastutilNonExisting       1  avgt    3     1,855 ±     0,133  ns/op
 * FastUtilBenchmark.uuidListFastutilNonExisting       3  avgt    3     2,620 ±     0,464  ns/op
 * FastUtilBenchmark.uuidListFastutilNonExisting       5  avgt    3     3,306 ±     0,620  ns/op
 * FastUtilBenchmark.uuidListFastutilNonExisting       8  avgt    3     3,849 ±     0,541  ns/op
 * FastUtilBenchmark.uuidListFastutilNonExisting      10  avgt    3     4,442 ±     0,621  ns/op
 * FastUtilBenchmark.uuidListFastutilNonExisting     100  avgt    3    32,613 ±     2,000  ns/op
 * FastUtilBenchmark.uuidListFastutilNonExisting    1000  avgt    3   474,813 ±    50,435  ns/op
 * FastUtilBenchmark.uuidListFastutilNonExisting   10000  avgt    3  5726,218 ± 25733,224  ns/op
 * FastUtilBenchmark.uuidListJavaExisting              1  avgt    3     0,886 ±     0,084  ns/op
 * FastUtilBenchmark.uuidListJavaExisting              3  avgt    3     1,750 ±     0,087  ns/op
 * FastUtilBenchmark.uuidListJavaExisting              5  avgt    3     2,063 ±     0,054  ns/op
 * FastUtilBenchmark.uuidListJavaExisting              8  avgt    3     3,047 ±     0,543  ns/op
 * FastUtilBenchmark.uuidListJavaExisting             10  avgt    3     3,232 ±     0,148  ns/op
 * FastUtilBenchmark.uuidListJavaExisting            100  avgt    3    12,892 ±     1,579  ns/op
 * FastUtilBenchmark.uuidListJavaExisting           1000  avgt    3    99,454 ±    20,080  ns/op
 * FastUtilBenchmark.uuidListJavaExisting          10000  avgt    3  2360,507 ±    89,472  ns/op
 * FastUtilBenchmark.uuidListJavaNonExisting           1  avgt    3     1,836 ±     0,012  ns/op
 * FastUtilBenchmark.uuidListJavaNonExisting           3  avgt    3     2,572 ±     0,356  ns/op
 * FastUtilBenchmark.uuidListJavaNonExisting           5  avgt    3     3,218 ±     0,498  ns/op
 * FastUtilBenchmark.uuidListJavaNonExisting           8  avgt    3     4,036 ±     0,942  ns/op
 * FastUtilBenchmark.uuidListJavaNonExisting          10  avgt    3     4,416 ±     0,069  ns/op
 * FastUtilBenchmark.uuidListJavaNonExisting         100  avgt    3    28,116 ±     1,309  ns/op
 * FastUtilBenchmark.uuidListJavaNonExisting        1000  avgt    3   516,378 ±    27,891  ns/op
 * FastUtilBenchmark.uuidListJavaNonExisting       10000  avgt    3  5287,032 ±   761,593  ns/op
 * FastUtilBenchmark.uuidSetFastutilExisting           1  avgt    3     0,974 ±     0,072  ns/op
 * FastUtilBenchmark.uuidSetFastutilExisting           3  avgt    3     0,974 ±     0,168  ns/op
 * FastUtilBenchmark.uuidSetFastutilExisting           5  avgt    3     0,979 ±     0,170  ns/op
 * FastUtilBenchmark.uuidSetFastutilExisting           8  avgt    3     0,972 ±     0,013  ns/op
 * FastUtilBenchmark.uuidSetFastutilExisting          10  avgt    3     1,813 ±     0,103  ns/op
 * FastUtilBenchmark.uuidSetFastutilExisting         100  avgt    3     0,969 ±     0,010  ns/op
 * FastUtilBenchmark.uuidSetFastutilExisting        1000  avgt    3     1,030 ±     2,165  ns/op
 * FastUtilBenchmark.uuidSetFastutilExisting       10000  avgt    3     1,497 ±     0,094  ns/op
 * FastUtilBenchmark.uuidSetFastutilNonExisting        1  avgt    3     0,675 ±     0,021  ns/op
 * FastUtilBenchmark.uuidSetFastutilNonExisting        3  avgt    3     2,162 ±     0,261  ns/op
 * FastUtilBenchmark.uuidSetFastutilNonExisting        5  avgt    3     1,500 ±     0,086  ns/op
 * FastUtilBenchmark.uuidSetFastutilNonExisting        8  avgt    3     0,678 ±     0,041  ns/op
 * FastUtilBenchmark.uuidSetFastutilNonExisting       10  avgt    3     0,677 ±     0,045  ns/op
 * FastUtilBenchmark.uuidSetFastutilNonExisting      100  avgt    3     0,682 ±     0,039  ns/op
 * FastUtilBenchmark.uuidSetFastutilNonExisting     1000  avgt    3     0,684 ±     0,086  ns/op
 * FastUtilBenchmark.uuidSetFastutilNonExisting    10000  avgt    3     1,539 ±     0,040  ns/op
 * FastUtilBenchmark.uuidSetJavaExisting               1  avgt    3     1,064 ±     0,044  ns/op
 * FastUtilBenchmark.uuidSetJavaExisting               3  avgt    3     1,054 ±     0,170  ns/op
 * FastUtilBenchmark.uuidSetJavaExisting               5  avgt    3     1,055 ±     0,060  ns/op
 * FastUtilBenchmark.uuidSetJavaExisting               8  avgt    3     1,059 ±     0,027  ns/op
 * FastUtilBenchmark.uuidSetJavaExisting              10  avgt    3     1,061 ±     0,138  ns/op
 * FastUtilBenchmark.uuidSetJavaExisting             100  avgt    3     1,062 ±     0,070  ns/op
 * FastUtilBenchmark.uuidSetJavaExisting            1000  avgt    3     1,056 ±     0,065  ns/op
 * FastUtilBenchmark.uuidSetJavaExisting           10000  avgt    3     1,058 ±     0,065  ns/op
 * FastUtilBenchmark.uuidSetJavaNonExisting            1  avgt    3     1,034 ±     0,059  ns/op
 * FastUtilBenchmark.uuidSetJavaNonExisting            3  avgt    3     0,828 ±     0,045  ns/op
 * FastUtilBenchmark.uuidSetJavaNonExisting            5  avgt    3     0,837 ±     0,235  ns/op
 * FastUtilBenchmark.uuidSetJavaNonExisting            8  avgt    3     0,818 ±     0,029  ns/op
 * FastUtilBenchmark.uuidSetJavaNonExisting           10  avgt    3     1,039 ±     0,058  ns/op
 * FastUtilBenchmark.uuidSetJavaNonExisting          100  avgt    3     1,043 ±     0,067  ns/op
 * FastUtilBenchmark.uuidSetJavaNonExisting         1000  avgt    3     0,822 ±     0,072  ns/op
 * FastUtilBenchmark.uuidSetJavaNonExisting        10000  avgt    3     0,823 ±     0,046  ns/op
 * <p>
 * Considerations:
 *   - Fastutil handles primitives directly, avoiding boxing, causing them to be 2-3 times faster, they are also more memory-efficient.
 *   - For objects like UUIDs, fastutil is slightly worse but almost identical to Java collections, although it gives unstable results.
 *   - Fastutil is the best for primitive types.
 */

package com.github.alegavuni.matte1cat.javabenchmarks.benchmarks;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.*;

@State(Scope.Thread)
public class FastUtilBenchmark {
    @Param({"1", "3", "5", "8", "10", "100", "1000", "10000"})
    private int size;

    // UUID (Object)

    private UUID existingUuid;
    private UUID nonExistingUuid;

    private Set<UUID> javaUuidSet;
    private List<UUID> javaUuidList;

    private ObjectOpenHashSet<UUID> fastutilUuidSet;
    private ObjectArrayList<UUID> fastutilUuidList;

    // long (primitive)

    private long existingLong;
    private long nonExistingLong;

    private Set<Long> javaLongSet;
    private LongOpenHashSet fastutilLongSet;

    @Setup(Level.Trial)
    public void setup() {
        Random random = new Random(12345);

        // UUID Collections
        javaUuidSet = new HashSet<>(size);
        javaUuidList = new ArrayList<>(size);
        fastutilUuidSet = new ObjectOpenHashSet<>(size);
        fastutilUuidList = new ObjectArrayList<>(size);

        List<UUID> allUuids = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            UUID uuid = UUID.randomUUID();
            allUuids.add(uuid);
            javaUuidSet.add(uuid);
            javaUuidList.add(uuid);
            fastutilUuidSet.add(uuid);
            fastutilUuidList.add(uuid);
        }

        existingUuid = allUuids.get(size / 2);
        do {
            nonExistingUuid = UUID.randomUUID();
        } while (javaUuidSet.contains(nonExistingUuid));

        // long Collections
        javaLongSet = new HashSet<>(size);
        fastutilLongSet = new LongOpenHashSet(size);

        List<Long> allLongs = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            long v = random.nextLong();
            allLongs.add(v);
            javaLongSet.add(v);
            fastutilLongSet.add(v);
        }

        existingLong = allLongs.get(size / 2);
        do {
            nonExistingLong = random.nextLong();
        } while (javaLongSet.contains(nonExistingLong));
    }

    // Long Set (primitive long)
    @Benchmark
    public void longSetJavaExisting(Blackhole bh) {
        bh.consume(javaLongSet.contains(existingLong));
    }

    @Benchmark
    public void longSetJavaNonExisting(Blackhole bh) {
        bh.consume(javaLongSet.contains(nonExistingLong));
    }

    @Benchmark
    public void longSetFastutilExisting(Blackhole bh) {
        bh.consume(fastutilLongSet.contains(existingLong));
    }

    @Benchmark
    public void longSetFastutilNonExisting(Blackhole bh) {
        bh.consume(fastutilLongSet.contains(nonExistingLong));
    }

    // UUID Set
    @Benchmark
    public void uuidSetJavaExisting(Blackhole bh) {
        bh.consume(javaUuidSet.contains(existingUuid));
    }

    @Benchmark
    public void uuidSetJavaNonExisting(Blackhole bh) {
        bh.consume(javaUuidSet.contains(nonExistingUuid));
    }

    @Benchmark
    public void uuidSetFastutilExisting(Blackhole bh) {
        bh.consume(fastutilUuidSet.contains(existingUuid));
    }

    @Benchmark
    public void uuidSetFastutilNonExisting(Blackhole bh) {
        bh.consume(fastutilUuidSet.contains(nonExistingUuid));
    }

    // UUID List
    @Benchmark
    public void uuidListJavaExisting(Blackhole bh) {
        bh.consume(javaUuidList.contains(existingUuid));
    }

    @Benchmark
    public void uuidListJavaNonExisting(Blackhole bh) {
        bh.consume(javaUuidList.contains(nonExistingUuid));
    }

    @Benchmark
    public void uuidListFastutilExisting(Blackhole bh) {
        bh.consume(fastutilUuidList.contains(existingUuid));
    }

    @Benchmark
    public void uuidListFastutilNonExisting(Blackhole bh) {
        bh.consume(fastutilUuidList.contains(nonExistingUuid));
    }

}
