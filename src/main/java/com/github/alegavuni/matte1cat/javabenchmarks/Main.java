package com.github.alegavuni.matte1cat.javabenchmarks;

import com.github.alegavuni.matte1cat.javabenchmarks.benchmarks.AccessLatencyBenchmark;
import com.github.alegavuni.matte1cat.javabenchmarks.benchmarks.CollectionsBenchmark;
import com.github.alegavuni.matte1cat.javabenchmarks.benchmarks.HashingBenchmarks;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws Exception {
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));

        // Create subfolders if they don't exist
        new File("results/latency").mkdirs();
        new File("results/collections").mkdirs();
        new File("results/hashing").mkdirs();

        Options opt = new OptionsBuilder()
                .include(AccessLatencyBenchmark.class.getName())
                .warmupIterations(2)
                .warmupTime(TimeValue.milliseconds(500))
                .measurementIterations(3)
                .measurementTime(TimeValue.milliseconds(500))
                .forks(1)
                .mode(org.openjdk.jmh.annotations.Mode.AverageTime)
                .timeUnit(TimeUnit.NANOSECONDS)
                .result("results/latency/latency-" + date + ".json")
                .resultFormat(ResultFormatType.JSON)
                .build();

        new Runner(opt).run();

        Options opt2 = new OptionsBuilder()
                .include(CollectionsBenchmark.class.getName())
                .warmupIterations(2)
                .warmupTime(TimeValue.milliseconds(500))
                .measurementIterations(3)
                .measurementTime(TimeValue.milliseconds(500))
                .forks(1)
                .mode(org.openjdk.jmh.annotations.Mode.AverageTime)
                .timeUnit(TimeUnit.NANOSECONDS)
                .result("results/collections/collections-" + date + ".json")
                .resultFormat(ResultFormatType.JSON)
                .build();

        new Runner(opt2).run();

        Options opt3 = new OptionsBuilder()
                .include(HashingBenchmarks.class.getName())
                .warmupIterations(2)
                .warmupTime(TimeValue.milliseconds(500))
                .measurementIterations(3)
                .measurementTime(TimeValue.milliseconds(500))
                .forks(1)
                .mode(org.openjdk.jmh.annotations.Mode.AverageTime)
                .timeUnit(TimeUnit.NANOSECONDS)
                .result("results/hashing/hashing-" + date + ".json")
                .resultFormat(ResultFormatType.JSON)
                .build();

        new Runner(opt3).run();
    }
}
