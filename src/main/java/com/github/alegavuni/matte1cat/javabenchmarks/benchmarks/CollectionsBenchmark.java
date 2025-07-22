/**
 * Results depend on hardware and JVM; consider them as a reference only.
 * Benchmarking results on a Ryzen 7 9700X, DDR5 RAM:
 * Benchmark                                   (size)  Mode  Cnt      Score      Error  Units
 * CollectionsBenchmark.arrayListExisting           1  avgt    3      0,687 ±    0,023  ns/op
 * CollectionsBenchmark.arrayListExisting           3  avgt    3      1,688 ±    0,240  ns/op
 * CollectionsBenchmark.arrayListExisting           5  avgt    3      1,738 ±    0,211  ns/op
 * CollectionsBenchmark.arrayListExisting           8  avgt    3      2,278 ±    0,553  ns/op
 * CollectionsBenchmark.arrayListExisting          10  avgt    3      3,107 ±    0,421  ns/op
 * CollectionsBenchmark.arrayListExisting         100  avgt    3     12,220 ±    1,714  ns/op
 * CollectionsBenchmark.arrayListExisting        1000  avgt    3    105,364 ±    2,751  ns/op
 * CollectionsBenchmark.arrayListExisting       10000  avgt    3   2427,705 ±   61,412  ns/op
 * CollectionsBenchmark.arrayListNonExisting        1  avgt    3      1,745 ±    0,238  ns/op
 * CollectionsBenchmark.arrayListNonExisting        3  avgt    3      2,497 ±    0,305  ns/op
 * CollectionsBenchmark.arrayListNonExisting        5  avgt    3      3,104 ±    0,463  ns/op
 * CollectionsBenchmark.arrayListNonExisting        8  avgt    3      3,726 ±    0,082  ns/op
 * CollectionsBenchmark.arrayListNonExisting       10  avgt    3      3,999 ±    0,445  ns/op
 * CollectionsBenchmark.arrayListNonExisting      100  avgt    3     21,967 ±    1,153  ns/op
 * CollectionsBenchmark.arrayListNonExisting     1000  avgt    3    444,128 ±   54,406  ns/op
 * CollectionsBenchmark.arrayListNonExisting    10000  avgt    3   5257,291 ± 1757,724  ns/op
 * CollectionsBenchmark.enumSetExisting             1  avgt    3      0,358 ±    0,042  ns/op
 * CollectionsBenchmark.enumSetExisting             3  avgt    3      0,358 ±    0,057  ns/op
 * CollectionsBenchmark.enumSetExisting             5  avgt    3      0,350 ±    0,078  ns/op
 * CollectionsBenchmark.enumSetExisting             8  avgt    3      0,364 ±    0,033  ns/op
 * CollectionsBenchmark.enumSetExisting            10  avgt    3      0,350 ±    0,120  ns/op
 * CollectionsBenchmark.enumSetExisting           100  avgt    3      0,354 ±    0,187  ns/op
 * CollectionsBenchmark.enumSetExisting          1000  avgt    3      0,360 ±    0,032  ns/op
 * CollectionsBenchmark.enumSetExisting         10000  avgt    3      0,361 ±    0,116  ns/op
 * CollectionsBenchmark.enumSetNonExisting          1  avgt    3      0,350 ±    0,045  ns/op
 * CollectionsBenchmark.enumSetNonExisting          3  avgt    3      0,349 ±    0,065  ns/op
 * CollectionsBenchmark.enumSetNonExisting          5  avgt    3      0,352 ±    0,032  ns/op
 * CollectionsBenchmark.enumSetNonExisting          8  avgt    3      0,352 ±    0,057  ns/op
 * CollectionsBenchmark.enumSetNonExisting         10  avgt    3      0,347 ±    0,060  ns/op
 * CollectionsBenchmark.enumSetNonExisting        100  avgt    3      0,352 ±    0,027  ns/op
 * CollectionsBenchmark.enumSetNonExisting       1000  avgt    3      0,348 ±    0,019  ns/op
 * CollectionsBenchmark.enumSetNonExisting      10000  avgt    3      0,351 ±    0,026  ns/op
 * CollectionsBenchmark.hashMapExisting             1  avgt    3      0,723 ±    0,106  ns/op
 * CollectionsBenchmark.hashMapExisting             3  avgt    3      0,775 ±    0,083  ns/op
 * CollectionsBenchmark.hashMapExisting             5  avgt    3      0,727 ±    0,005  ns/op
 * CollectionsBenchmark.hashMapExisting             8  avgt    3      0,727 ±    0,014  ns/op
 * CollectionsBenchmark.hashMapExisting            10  avgt    3      0,733 ±    0,063  ns/op
 * CollectionsBenchmark.hashMapExisting           100  avgt    3      0,725 ±    0,112  ns/op
 * CollectionsBenchmark.hashMapExisting          1000  avgt    3      0,982 ±    0,198  ns/op
 * CollectionsBenchmark.hashMapExisting         10000  avgt    3      0,981 ±    0,083  ns/op
 * CollectionsBenchmark.hashMapNonExisting          1  avgt    3      0,748 ±    0,042  ns/op
 * CollectionsBenchmark.hashMapNonExisting          3  avgt    3      0,744 ±    0,051  ns/op
 * CollectionsBenchmark.hashMapNonExisting          5  avgt    3      0,745 ±    0,028  ns/op
 * CollectionsBenchmark.hashMapNonExisting          8  avgt    3      0,746 ±    0,109  ns/op
 * CollectionsBenchmark.hashMapNonExisting         10  avgt    3      0,741 ±    0,047  ns/op
 * CollectionsBenchmark.hashMapNonExisting        100  avgt    3      0,764 ±    0,023  ns/op
 * CollectionsBenchmark.hashMapNonExisting       1000  avgt    3      0,745 ±    0,122  ns/op
 * CollectionsBenchmark.hashMapNonExisting      10000  avgt    3      0,767 ±    0,149  ns/op
 * CollectionsBenchmark.hashSetExisting             1  avgt    3      0,834 ±    0,089  ns/op
 * CollectionsBenchmark.hashSetExisting             3  avgt    3      0,841 ±    0,153  ns/op
 * CollectionsBenchmark.hashSetExisting             5  avgt    3      0,829 ±    0,050  ns/op
 * CollectionsBenchmark.hashSetExisting             8  avgt    3      0,832 ±    0,009  ns/op
 * CollectionsBenchmark.hashSetExisting            10  avgt    3      0,840 ±    0,151  ns/op
 * CollectionsBenchmark.hashSetExisting           100  avgt    3      0,838 ±    0,135  ns/op
 * CollectionsBenchmark.hashSetExisting          1000  avgt    3      1,113 ±    0,059  ns/op
 * CollectionsBenchmark.hashSetExisting         10000  avgt    3      1,109 ±    0,035  ns/op
 * CollectionsBenchmark.hashSetNonExisting          1  avgt    3      0,822 ±    0,046  ns/op
 * CollectionsBenchmark.hashSetNonExisting          3  avgt    3      0,829 ±    0,064  ns/op
 * CollectionsBenchmark.hashSetNonExisting          5  avgt    3      0,824 ±    0,032  ns/op
 * CollectionsBenchmark.hashSetNonExisting          8  avgt    3      0,827 ±    0,018  ns/op
 * CollectionsBenchmark.hashSetNonExisting         10  avgt    3      0,829 ±    0,092  ns/op
 * CollectionsBenchmark.hashSetNonExisting        100  avgt    3      0,831 ±    0,068  ns/op
 * CollectionsBenchmark.hashSetNonExisting       1000  avgt    3      0,828 ±    0,064  ns/op
 * CollectionsBenchmark.hashSetNonExisting      10000  avgt    3      0,827 ±    0,047  ns/op
 * CollectionsBenchmark.linkedListExisting          1  avgt    3      0,558 ±    0,060  ns/op
 * CollectionsBenchmark.linkedListExisting          3  avgt    3      1,009 ±    0,040  ns/op
 * CollectionsBenchmark.linkedListExisting          5  avgt    3      1,476 ±    0,091  ns/op
 * CollectionsBenchmark.linkedListExisting          8  avgt    3      2,548 ±    0,085  ns/op
 * CollectionsBenchmark.linkedListExisting         10  avgt    3      2,979 ±    0,155  ns/op
 * CollectionsBenchmark.linkedListExisting        100  avgt    3     48,162 ±   13,134  ns/op
 * CollectionsBenchmark.linkedListExisting       1000  avgt    3   1079,460 ±   75,319  ns/op
 * CollectionsBenchmark.linkedListExisting      10000  avgt    3  16570,537 ± 2019,035  ns/op
 * CollectionsBenchmark.linkedListNonExisting       1  avgt    3      0,730 ±    0,040  ns/op
 * CollectionsBenchmark.linkedListNonExisting       3  avgt    3      1,613 ±    0,216  ns/op
 * CollectionsBenchmark.linkedListNonExisting       5  avgt    3      2,581 ±    0,137  ns/op
 * CollectionsBenchmark.linkedListNonExisting       8  avgt    3      4,339 ±    0,062  ns/op
 * CollectionsBenchmark.linkedListNonExisting      10  avgt    3      5,611 ±    0,169  ns/op
 * CollectionsBenchmark.linkedListNonExisting     100  avgt    3     86,487 ±    1,378  ns/op
 * CollectionsBenchmark.linkedListNonExisting    1000  avgt    3   2289,386 ±  462,482  ns/op
 * CollectionsBenchmark.linkedListNonExisting   10000  avgt    3  42279,106 ± 4523,278  ns/op
 * CollectionsBenchmark.queuePeek                   1  avgt    3      0,495 ±    0,024  ns/op
 * CollectionsBenchmark.queuePeek                   3  avgt    3      0,484 ±    0,030  ns/op
 * CollectionsBenchmark.queuePeek                   5  avgt    3      0,494 ±    0,025  ns/op
 * CollectionsBenchmark.queuePeek                   8  avgt    3      0,494 ±    0,055  ns/op
 * CollectionsBenchmark.queuePeek                  10  avgt    3      0,495 ±    0,056  ns/op
 * CollectionsBenchmark.queuePeek                 100  avgt    3      0,490 ±    0,073  ns/op
 * CollectionsBenchmark.queuePeek                1000  avgt    3      0,488 ±    0,071  ns/op
 * CollectionsBenchmark.queuePeek               10000  avgt    3      0,486 ±    0,033  ns/op
 * CollectionsBenchmark.sortedSetExisting           1  avgt    3      0,883 ±    0,078  ns/op
 * CollectionsBenchmark.sortedSetExisting           3  avgt    3      0,890 ±    0,066  ns/op
 * CollectionsBenchmark.sortedSetExisting           5  avgt    3      2,180 ±    2,094  ns/op
 * CollectionsBenchmark.sortedSetExisting           8  avgt    3      2,045 ±    0,718  ns/op
 * CollectionsBenchmark.sortedSetExisting          10  avgt    3      1,363 ±    0,052  ns/op
 * CollectionsBenchmark.sortedSetExisting         100  avgt    3      4,673 ±    1,137  ns/op
 * CollectionsBenchmark.sortedSetExisting        1000  avgt    3      6,853 ±    0,390  ns/op
 * CollectionsBenchmark.sortedSetExisting       10000  avgt    3      9,267 ±    2,289  ns/op
 * CollectionsBenchmark.sortedSetNonExisting        1  avgt    3      1,070 ±    0,018  ns/op
 * CollectionsBenchmark.sortedSetNonExisting        3  avgt    3      1,670 ±    0,218  ns/op
 * CollectionsBenchmark.sortedSetNonExisting        5  avgt    3      1,663 ±    0,091  ns/op
 * CollectionsBenchmark.sortedSetNonExisting        8  avgt    3      2,102 ±    0,133  ns/op
 * CollectionsBenchmark.sortedSetNonExisting       10  avgt    3      2,098 ±    0,141  ns/op
 * CollectionsBenchmark.sortedSetNonExisting      100  avgt    3      3,840 ±    0,112  ns/op
 * CollectionsBenchmark.sortedSetNonExisting     1000  avgt    3      5,827 ±    0,169  ns/op
 * CollectionsBenchmark.sortedSetNonExisting    10000  avgt    3      7,751 ±    0,204  ns/op
 * CollectionsBenchmark.treeSetExisting             1  avgt    3      0,835 ±    0,379  ns/op
 * CollectionsBenchmark.treeSetExisting             3  avgt    3      0,847 ±    0,013  ns/op
 * CollectionsBenchmark.treeSetExisting             5  avgt    3      2,028 ±    0,283  ns/op
 * CollectionsBenchmark.treeSetExisting             8  avgt    3      3,283 ±    0,974  ns/op
 * CollectionsBenchmark.treeSetExisting            10  avgt    3      1,597 ±    0,219  ns/op
 * CollectionsBenchmark.treeSetExisting           100  avgt    3      4,733 ±    0,940  ns/op
 * CollectionsBenchmark.treeSetExisting          1000  avgt    3      7,513 ±    2,387  ns/op
 * CollectionsBenchmark.treeSetExisting         10000  avgt    3      9,520 ±    1,572  ns/op
 * CollectionsBenchmark.treeSetNonExisting          1  avgt    3      1,004 ±    0,037  ns/op
 * CollectionsBenchmark.treeSetNonExisting          3  avgt    3      1,485 ±    0,061  ns/op
 * CollectionsBenchmark.treeSetNonExisting          5  avgt    3      1,481 ±    0,024  ns/op
 * CollectionsBenchmark.treeSetNonExisting          8  avgt    3      2,022 ±    0,167  ns/op
 * CollectionsBenchmark.treeSetNonExisting         10  avgt    3      2,024 ±    0,110  ns/op
 * CollectionsBenchmark.treeSetNonExisting        100  avgt    3      3,712 ±    0,106  ns/op
 * CollectionsBenchmark.treeSetNonExisting       1000  avgt    3      5,647 ±    0,226  ns/op
 * CollectionsBenchmark.treeSetNonExisting      10000  avgt    3      7,652 ±    0,627  ns/op
 * <p>
 * Considerations:
 *   - EnumSet: fastest, stable ~0.35 ns, bitset-based, O(1)
 *   - HashMap/HashSet: fast ~0.7–1.1 ns, O(1), good hashing
 *   - ArrayList: slow, O(n), time grows linearly with size
 *   - LinkedList: slowest, O(n), costly traversal
 *   - TreeSet/SortedSet: O(log n), slower than hash, but keeps order
 *   - Queue.peek(): O(1), stable ~0.50 ns, very fast constant time
 * Additional notes on searching existing vs non-existing elements (searching for the middle element):
 *   - Linear scans are approximately twice as slow when the element doesn't exist due to the constraints we applied.
 *   - Hash-based structures have similar timings; searching for non-existing elements can be faster since it often avoids calling equals.
 * EnumSets are the fastest, followed by hash-based types. LinkedList is by far the worst, being about 8 times slower than an ArrayList.
 */

package com.github.alegavuni.matte1cat.javabenchmarks.benchmarks;

import com.github.alegavuni.matte1cat.javabenchmarks.utils.SampleEnum;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.*;

@State(Scope.Thread)
public class CollectionsBenchmark {

    @Param({"1", "3", "5", "8", "10", "100", "1000", "10000"})
    private int size;

    private Integer existing;
    private Integer nonExisting;

    private ArrayList<Integer> arrayList;
    private LinkedList<Integer> linkedList;
    private HashSet<Integer> hashSet;
    private TreeSet<Integer> treeSet;
    private HashMap<Integer, Integer> hashMap;
    private EnumSet<SampleEnum> enumSet;
    private Queue<Integer> queue;
    private SortedSet<Integer> sortedSet;

    @Setup(Level.Trial)
    public void setup() {
        existing = size / 2;
        nonExisting = -1;

        arrayList = new ArrayList<>(size);
        linkedList = new LinkedList<>();
        hashSet = new HashSet<>(size);
        treeSet = new TreeSet<>();
        hashMap = new HashMap<>(size);
        enumSet = EnumSet.noneOf(SampleEnum.class);
        queue = new ArrayDeque<>(size);
        sortedSet = new TreeSet<>();

        for (int i = 0; i < size; i++) {
            arrayList.add(i);
            linkedList.add(i);
            hashSet.add(i);
            treeSet.add(i);
            hashMap.put(i, i);
            if (i < SampleEnum.values().length) {
                enumSet.add(SampleEnum.values()[i]);
            }
            queue.add(i);
            sortedSet.add(i);
        }
    }

    // ArrayList
    @Benchmark
    public void arrayListExisting(Blackhole bh) {
        bh.consume(arrayList.contains(existing));
    }

    @Benchmark
    public void arrayListNonExisting(Blackhole bh) {
        bh.consume(arrayList.contains(nonExisting));
    }

    // LinkedList
    @Benchmark
    public void linkedListExisting(Blackhole bh) {
        bh.consume(linkedList.contains(existing));
    }

    @Benchmark
    public void linkedListNonExisting(Blackhole bh) {
        bh.consume(linkedList.contains(nonExisting));
    }

    // HashSet
    @Benchmark
    public void hashSetExisting(Blackhole bh) {
        bh.consume(hashSet.contains(existing));
    }

    @Benchmark
    public void hashSetNonExisting(Blackhole bh) {
        bh.consume(hashSet.contains(nonExisting));
    }

    // TreeSet
    @Benchmark
    public void treeSetExisting(Blackhole bh) {
        bh.consume(treeSet.contains(existing));
    }

    @Benchmark
    public void treeSetNonExisting(Blackhole bh) {
        bh.consume(treeSet.contains(nonExisting));
    }

    // HashMap
    @Benchmark
    public void hashMapExisting(Blackhole bh) {
        bh.consume(hashMap.containsKey(existing));
    }

    @Benchmark
    public void hashMapNonExisting(Blackhole bh) {
        bh.consume(hashMap.containsKey(nonExisting));
    }

    // EnumSet
    @Benchmark
    public void enumSetExisting(Blackhole bh) {
        bh.consume(enumSet.contains(SampleEnum.A));
    }

    @Benchmark
    public void enumSetNonExisting(Blackhole bh) {
        bh.consume(enumSet.contains(SampleEnum.Z));
    }

    // Queue
    @Benchmark
    public void queuePeek(Blackhole bh) {
        bh.consume(queue.peek());
    }

    // SortedSet
    @Benchmark
    public void sortedSetExisting(Blackhole bh) {
        bh.consume(sortedSet.contains(existing));
    }

    @Benchmark
    public void sortedSetNonExisting(Blackhole bh) {
        bh.consume(sortedSet.contains(nonExisting));
    }

}
