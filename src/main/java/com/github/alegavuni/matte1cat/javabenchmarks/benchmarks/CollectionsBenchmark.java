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
