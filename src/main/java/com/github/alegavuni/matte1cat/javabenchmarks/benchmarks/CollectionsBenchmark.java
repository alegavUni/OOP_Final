/**
 * Benchmark                                          (size)  Mode  Cnt     Score       Error  Units
 * CollectionsBenchmark.fastutilLongSet_existing           1  avgt    3     0,608 ±     0,060  ns/op
 * CollectionsBenchmark.fastutilLongSet_existing           3  avgt    3     0,604 ±     0,124  ns/op
 * CollectionsBenchmark.fastutilLongSet_existing           5  avgt    3     0,592 ±     0,060  ns/op
 * CollectionsBenchmark.fastutilLongSet_existing           8  avgt    3     0,614 ±     0,083  ns/op
 * CollectionsBenchmark.fastutilLongSet_existing          10  avgt    3     1,164 ±     0,149  ns/op
 * CollectionsBenchmark.fastutilLongSet_existing         100  avgt    3     0,597 ±     0,157  ns/op
 * CollectionsBenchmark.fastutilLongSet_existing        1000  avgt    3     0,605 ±     0,125  ns/op
 * CollectionsBenchmark.fastutilLongSet_existing       10000  avgt    3     0,607 ±     0,085  ns/op
 * CollectionsBenchmark.fastutilLongSet_nonExisting        1  avgt    3     1,112 ±     0,033  ns/op
 * CollectionsBenchmark.fastutilLongSet_nonExisting        3  avgt    3     1,938 ±     0,101  ns/op
 * CollectionsBenchmark.fastutilLongSet_nonExisting        5  avgt    3     1,106 ±     0,123  ns/op
 * CollectionsBenchmark.fastutilLongSet_nonExisting        8  avgt    3     0,555 ±     0,061  ns/op
 * CollectionsBenchmark.fastutilLongSet_nonExisting       10  avgt    3     2,072 ±     0,058  ns/op
 * CollectionsBenchmark.fastutilLongSet_nonExisting      100  avgt    3     0,578 ±     0,099  ns/op
 * CollectionsBenchmark.fastutilLongSet_nonExisting     1000  avgt    3     2,455 ±     0,169  ns/op
 * CollectionsBenchmark.fastutilLongSet_nonExisting    10000  avgt    3     2,434 ±     0,059  ns/op
 * CollectionsBenchmark.fastutilUuidList_existing          1  avgt    3     0,464 ±     0,039  ns/op
 * CollectionsBenchmark.fastutilUuidList_existing          3  avgt    3     1,361 ±     0,105  ns/op
 * CollectionsBenchmark.fastutilUuidList_existing          5  avgt    3     1,902 ±     0,042  ns/op
 * CollectionsBenchmark.fastutilUuidList_existing          8  avgt    3     2,734 ±     0,171  ns/op
 * CollectionsBenchmark.fastutilUuidList_existing         10  avgt    3     3,311 ±     0,406  ns/op
 * CollectionsBenchmark.fastutilUuidList_existing        100  avgt    3    17,387 ±     1,251  ns/op
 * CollectionsBenchmark.fastutilUuidList_existing       1000  avgt    3   179,118 ±   291,644  ns/op
 * CollectionsBenchmark.fastutilUuidList_existing      10000  avgt    3  2416,371 ±  4100,677  ns/op
 * CollectionsBenchmark.fastutilUuidList_nonExisting       1  avgt    3     1,883 ±     0,302  ns/op
 * CollectionsBenchmark.fastutilUuidList_nonExisting       3  avgt    3     2,731 ±     3,146  ns/op
 * CollectionsBenchmark.fastutilUuidList_nonExisting       5  avgt    3     3,356 ±     0,104  ns/op
 * CollectionsBenchmark.fastutilUuidList_nonExisting       8  avgt    3     3,936 ±     0,947  ns/op
 * CollectionsBenchmark.fastutilUuidList_nonExisting      10  avgt    3     4,497 ±     0,211  ns/op
 * CollectionsBenchmark.fastutilUuidList_nonExisting     100  avgt    3    33,018 ±     1,822  ns/op
 * CollectionsBenchmark.fastutilUuidList_nonExisting    1000  avgt    3   461,067 ±   698,769  ns/op
 * CollectionsBenchmark.fastutilUuidList_nonExisting   10000  avgt    3  5165,634 ± 18263,512  ns/op
 * CollectionsBenchmark.fastutilUuidSet_existing           1  avgt    3     0,988 ±     0,126  ns/op
 * CollectionsBenchmark.fastutilUuidSet_existing           3  avgt    3     1,572 ±    12,249  ns/op
 * CollectionsBenchmark.fastutilUuidSet_existing           5  avgt    3     1,800 ±    13,234  ns/op
 * CollectionsBenchmark.fastutilUuidSet_existing           8  avgt    3     1,363 ±     0,026  ns/op
 * CollectionsBenchmark.fastutilUuidSet_existing          10  avgt    3     0,970 ±     0,060  ns/op
 * CollectionsBenchmark.fastutilUuidSet_existing         100  avgt    3     1,187 ±     0,261  ns/op
 * CollectionsBenchmark.fastutilUuidSet_existing        1000  avgt    3     1,357 ±     0,084  ns/op
 * CollectionsBenchmark.fastutilUuidSet_existing       10000  avgt    3     4,028 ±    77,613  ns/op
 * CollectionsBenchmark.fastutilUuidSet_nonExisting        1  avgt    3     1,383 ±     3,282  ns/op
 * CollectionsBenchmark.fastutilUuidSet_nonExisting        3  avgt    3     1,556 ±    26,489  ns/op
 * CollectionsBenchmark.fastutilUuidSet_nonExisting        5  avgt    3     1,431 ±    13,610  ns/op
 * CollectionsBenchmark.fastutilUuidSet_nonExisting        8  avgt    3     1,854 ±    13,751  ns/op
 * CollectionsBenchmark.fastutilUuidSet_nonExisting       10  avgt    3     4,084 ±    33,697  ns/op
 * CollectionsBenchmark.fastutilUuidSet_nonExisting      100  avgt    3     1,601 ±     0,170  ns/op
 * CollectionsBenchmark.fastutilUuidSet_nonExisting     1000  avgt    3     1,909 ±    19,196  ns/op
 * CollectionsBenchmark.fastutilUuidSet_nonExisting    10000  avgt    3     3,002 ±    25,941  ns/op
 * CollectionsBenchmark.javaLongSet_existing               1  avgt    3     1,646 ±     0,096  ns/op
 * CollectionsBenchmark.javaLongSet_existing               3  avgt    3     1,613 ±     0,171  ns/op
 * CollectionsBenchmark.javaLongSet_existing               5  avgt    3     1,618 ±     0,038  ns/op
 * CollectionsBenchmark.javaLongSet_existing               8  avgt    3     1,630 ±     0,035  ns/op
 * CollectionsBenchmark.javaLongSet_existing              10  avgt    3     2,032 ±     0,243  ns/op
 * CollectionsBenchmark.javaLongSet_existing             100  avgt    3     1,611 ±     0,098  ns/op
 * CollectionsBenchmark.javaLongSet_existing            1000  avgt    3     2,359 ±     0,026  ns/op
 * CollectionsBenchmark.javaLongSet_existing           10000  avgt    3     1,622 ±     0,044  ns/op
 * CollectionsBenchmark.javaLongSet_nonExisting            1  avgt    3     1,317 ±     0,046  ns/op
 * CollectionsBenchmark.javaLongSet_nonExisting            3  avgt    3     1,840 ±     0,879  ns/op
 * CollectionsBenchmark.javaLongSet_nonExisting            5  avgt    3     1,743 ±     0,052  ns/op
 * CollectionsBenchmark.javaLongSet_nonExisting            8  avgt    3     1,330 ±     0,027  ns/op
 * CollectionsBenchmark.javaLongSet_nonExisting           10  avgt    3     1,399 ±     0,030  ns/op
 * CollectionsBenchmark.javaLongSet_nonExisting          100  avgt    3     1,312 ±     0,102  ns/op
 * CollectionsBenchmark.javaLongSet_nonExisting         1000  avgt    3     1,350 ±     0,071  ns/op
 * CollectionsBenchmark.javaLongSet_nonExisting        10000  avgt    3     1,463 ±     0,595  ns/op
 * CollectionsBenchmark.javaUuidList_existing              1  avgt    3     0,892 ±     0,020  ns/op
 * CollectionsBenchmark.javaUuidList_existing              3  avgt    3     1,780 ±     0,153  ns/op
 * CollectionsBenchmark.javaUuidList_existing              5  avgt    3     1,976 ±     0,032  ns/op
 * CollectionsBenchmark.javaUuidList_existing              8  avgt    3     2,621 ±     0,618  ns/op
 * CollectionsBenchmark.javaUuidList_existing             10  avgt    3     3,263 ±     0,248  ns/op
 * CollectionsBenchmark.javaUuidList_existing            100  avgt    3    12,959 ±     0,702  ns/op
 * CollectionsBenchmark.javaUuidList_existing           1000  avgt    3   115,483 ±   324,397  ns/op
 * CollectionsBenchmark.javaUuidList_existing          10000  avgt    3  2345,642 ±  3046,166  ns/op
 * CollectionsBenchmark.javaUuidList_nonExisting           1  avgt    3     1,844 ±     0,046  ns/op
 * CollectionsBenchmark.javaUuidList_nonExisting           3  avgt    3     2,592 ±     0,125  ns/op
 * CollectionsBenchmark.javaUuidList_nonExisting           5  avgt    3     3,232 ±     0,102  ns/op
 * CollectionsBenchmark.javaUuidList_nonExisting           8  avgt    3     3,964 ±     0,199  ns/op
 * CollectionsBenchmark.javaUuidList_nonExisting          10  avgt    3     4,607 ±     0,299  ns/op
 * CollectionsBenchmark.javaUuidList_nonExisting         100  avgt    3    28,883 ±    15,933  ns/op
 * CollectionsBenchmark.javaUuidList_nonExisting        1000  avgt    3   470,501 ±    59,039  ns/op
 * CollectionsBenchmark.javaUuidList_nonExisting       10000  avgt    3  5129,056 ±  8446,657  ns/op
 * CollectionsBenchmark.javaUuidSet_existing               1  avgt    3     1,043 ±     0,165  ns/op
 * CollectionsBenchmark.javaUuidSet_existing               3  avgt    3     1,165 ±     3,512  ns/op
 * CollectionsBenchmark.javaUuidSet_existing               5  avgt    3     1,048 ±     0,047  ns/op
 * CollectionsBenchmark.javaUuidSet_existing               8  avgt    3     1,044 ±     0,043  ns/op
 * CollectionsBenchmark.javaUuidSet_existing              10  avgt    3     1,402 ±     0,102  ns/op
 * CollectionsBenchmark.javaUuidSet_existing             100  avgt    3     1,039 ±     0,016  ns/op
 * CollectionsBenchmark.javaUuidSet_existing            1000  avgt    3     1,163 ±     3,812  ns/op
 * CollectionsBenchmark.javaUuidSet_existing           10000  avgt    3     1,052 ±     0,089  ns/op
 * CollectionsBenchmark.javaUuidSet_nonExisting            1  avgt    3     0,951 ±     2,308  ns/op
 * CollectionsBenchmark.javaUuidSet_nonExisting            3  avgt    3     0,915 ±     3,077  ns/op
 * CollectionsBenchmark.javaUuidSet_nonExisting            5  avgt    3     1,009 ±     3,019  ns/op
 * CollectionsBenchmark.javaUuidSet_nonExisting            8  avgt    3     0,962 ±     2,413  ns/op
 * CollectionsBenchmark.javaUuidSet_nonExisting           10  avgt    3     1,178 ±     4,637  ns/op
 * CollectionsBenchmark.javaUuidSet_nonExisting          100  avgt    3     0,890 ±     2,329  ns/op
 * CollectionsBenchmark.javaUuidSet_nonExisting         1000  avgt    3     1,096 ±     5,827  ns/op
 * CollectionsBenchmark.javaUuidSet_nonExisting        10000  avgt    3     0,915 ±     3,066  ns/op
 * <p>
 * Considerations:
 */

package com.github.alegavuni.matte1cat.javabenchmarks.benchmarks;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import org.openjdk.jmh.annotations.*;

import java.util.*;

@State(Scope.Thread)
public class CollectionsBenchmark {
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

    @Setup(Level.Iteration)
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

    // Java UUID Benchmarks
    @Benchmark public boolean javaUuidSet_existing() { return javaUuidSet.contains(existingUuid); }
    @Benchmark public boolean javaUuidSet_nonExisting() { return javaUuidSet.contains(nonExistingUuid); }

    @Benchmark public boolean javaUuidList_existing() { return javaUuidList.contains(existingUuid); }
    @Benchmark public boolean javaUuidList_nonExisting() { return javaUuidList.contains(nonExistingUuid); }

    // FastUtil UUID Benchmarks
    @Benchmark public boolean fastutilUuidSet_existing() { return fastutilUuidSet.contains(existingUuid); }
    @Benchmark public boolean fastutilUuidSet_nonExisting() { return fastutilUuidSet.contains(nonExistingUuid); }

    @Benchmark public boolean fastutilUuidList_existing() { return fastutilUuidList.contains(existingUuid); }
    @Benchmark public boolean fastutilUuidList_nonExisting() { return fastutilUuidList.contains(nonExistingUuid); }

    // Java Long (boxed) Benchmarks
    @Benchmark public boolean javaLongSet_existing() { return javaLongSet.contains(existingLong); }
    @Benchmark public boolean javaLongSet_nonExisting() { return javaLongSet.contains(nonExistingLong); }

    // FastUtil Long (primitive) Benchmarks
    @Benchmark public boolean fastutilLongSet_existing() { return fastutilLongSet.contains(existingLong); }
    @Benchmark public boolean fastutilLongSet_nonExisting() { return fastutilLongSet.contains(nonExistingLong); }
}
