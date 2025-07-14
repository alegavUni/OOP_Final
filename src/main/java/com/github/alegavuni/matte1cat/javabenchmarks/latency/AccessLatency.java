/**
 * Benchmarking results on a Ryzen 7 9700X, DDR5 RAM:
 * Benchmark                      Mode  Cnt  Score    Error  Units
 * Main.randomAccess_0000512      avgt    3  0,170 ±  0,030  ns/op
 * Main.randomAccess_0004096      avgt    3  0,209 ±  0,014  ns/op
 * Main.randomAccess_0016384      avgt    3  0,288 ±  0,068  ns/op
 * Main.randomAccess_0065536      avgt    3  0,453 ±  0,046  ns/op
 * Main.randomAccess_0262144      avgt    3  0,602 ±  1,984  ns/op
 * Main.randomAccess_1048576      avgt    3  0,935 ±  1,205  ns/op
 * Main.randomAccess_4194304      avgt    3  0,893 ±  3,018  ns/op
 * Main.sequentialAccess_0000512  avgt    3  0,051 ±  0,001  ns/op
 * Main.sequentialAccess_0004096  avgt    3  0,050 ±  0,001  ns/op
 * Main.sequentialAccess_0016384  avgt    3  0,058 ±  0,002  ns/op
 * Main.sequentialAccess_0065536  avgt    3  0,057 ±  0,001  ns/op
 * Main.sequentialAccess_0262144  avgt    3  0,058 ±  0,004  ns/op
 * Main.sequentialAccess_1048576  avgt    3  0,058 ±  0,001  ns/op
 * Main.sequentialAccess_4194304  avgt    3  0,059 ±  0,007  ns/op
 * <p>
 * Considerations:
 * - Sequential access is faster because of CPU cache prefetching.
 * - Latency increases with array size, especially in random access due to cache misses.
 * - Results depend on hardware and JVM; consider them as a reference only.
 */

package com.github.alegavuni.matte1cat.javabenchmarks.latency;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
@Warmup(iterations = 3, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 3, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(value = 1)
public class AccessLatency {

    // Max size for setup arrays
    private static final int MAX_SIZE = 4_194_304;

    private int[] array;
    private int[] randomIndices;

    @Setup(Level.Iteration)
    public void setup() {
        array = new int[MAX_SIZE];
        randomIndices = new int[MAX_SIZE];
        Random rand = new Random(42);

        for (int i = 0; i < MAX_SIZE; i++) {
            array[i] = i;
            randomIndices[i] = rand.nextInt(MAX_SIZE);
        }
    }

    @Benchmark
    @OperationsPerInvocation(512)
    public void sequentialAccess_0000512(Blackhole bh) {
        for (int i = 0; i < 512; i++) {
            bh.consume(array[i]);
        }
    }

    @Benchmark
    @OperationsPerInvocation(4096)
    public void sequentialAccess_0004096(Blackhole bh) {
        for (int i = 0; i < 4096; i++) {
            bh.consume(array[i]);
        }
    }

    @Benchmark
    @OperationsPerInvocation(16384)
    public void sequentialAccess_0016384(Blackhole bh) {
        for (int i = 0; i < 16384; i++) {
            bh.consume(array[i]);
        }
    }

    @Benchmark
    @OperationsPerInvocation(65536)
    public void sequentialAccess_0065536(Blackhole bh) {
        for (int i = 0; i < 65536; i++) {
            bh.consume(array[i]);
        }
    }

    @Benchmark
    @OperationsPerInvocation(262144)
    public void sequentialAccess_0262144(Blackhole bh) {
        for (int i = 0; i < 262144; i++) {
            bh.consume(array[i]);
        }
    }

    @Benchmark
    @OperationsPerInvocation(1048576)
    public void sequentialAccess_1048576(Blackhole bh) {
        for (int i = 0; i < 1048576; i++) {
            bh.consume(array[i]);
        }
    }

    @Benchmark
    @OperationsPerInvocation(4194304)
    public void sequentialAccess_4194304(Blackhole bh) {
        for (int i = 0; i < 4194304; i++) {
            bh.consume(array[i]);
        }
    }

    // Now the same for random access

    @Benchmark
    @OperationsPerInvocation(512)
    public void randomAccess_0000512(Blackhole bh) {
        for (int i = 0; i < 512; i++) {
            bh.consume(array[randomIndices[i]]);
        }
    }

    @Benchmark
    @OperationsPerInvocation(4096)
    public void randomAccess_0004096(Blackhole bh) {
        for (int i = 0; i < 4096; i++) {
            bh.consume(array[randomIndices[i]]);
        }
    }

    @Benchmark
    @OperationsPerInvocation(16384)
    public void randomAccess_0016384(Blackhole bh) {
        for (int i = 0; i < 16384; i++) {
            bh.consume(array[randomIndices[i]]);
        }
    }

    @Benchmark
    @OperationsPerInvocation(65536)
    public void randomAccess_0065536(Blackhole bh) {
        for (int i = 0; i < 65536; i++) {
            bh.consume(array[randomIndices[i]]);
        }
    }

    @Benchmark
    @OperationsPerInvocation(262144)
    public void randomAccess_0262144(Blackhole bh) {
        for (int i = 0; i < 262144; i++) {
            bh.consume(array[randomIndices[i]]);
        }
    }

    @Benchmark
    @OperationsPerInvocation(1048576)
    public void randomAccess_1048576(Blackhole bh) {
        for (int i = 0; i < 1048576; i++) {
            bh.consume(array[randomIndices[i]]);
        }
    }

    @Benchmark
    @OperationsPerInvocation(4194304)
    public void randomAccess_4194304(Blackhole bh) {
        for (int i = 0; i < 4194304; i++) {
            bh.consume(array[randomIndices[i]]);
        }
    }

}
