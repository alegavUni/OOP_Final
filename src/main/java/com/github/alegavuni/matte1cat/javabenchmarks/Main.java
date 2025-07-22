package com.github.alegavuni.matte1cat.javabenchmarks;

import com.github.alegavuni.matte1cat.javabenchmarks.benchmarks.*;
import com.github.alegavuni.matte1cat.javabenchmarks.utils.BenchmarkInfo;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());
    private static final String RESULTS_FOLDER = "results/";

    public static void main(String[] args) {
        List<BenchmarkInfo> benchmarks = List.of(
                new BenchmarkInfo("latency", AccessLatencyBenchmark.class),
                new BenchmarkInfo("collections", CollectionsBenchmark.class),
                new BenchmarkInfo("hashing", HashingBenchmark.class)
        );

        createResultFolders(benchmarks);

        for (BenchmarkInfo benchmark : benchmarks) {
            runBenchmark(benchmark);
        }
    }

    private static void createResultFolders(List<BenchmarkInfo> benchmarks) {
        benchmarks.forEach(benchmark -> {
            File dir = new File(RESULTS_FOLDER + benchmark.name());
            if (!dir.exists() && !dir.mkdirs()) {
                logger.severe("Failed to create directory: " + dir.getPath());
            }
        });
    }

    private static void runBenchmark(BenchmarkInfo benchmark) {
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
        String resultFile = RESULTS_FOLDER + benchmark.name() + "/" + benchmark.name() + "-" + date + ".json";

        try {
            Options opt = new OptionsBuilder()
                    .include(benchmark.clazz().getSimpleName())
                    .warmupIterations(2)
                    .warmupTime(TimeValue.milliseconds(500))
                    .measurementIterations(3)
                    .measurementTime(TimeValue.milliseconds(500))
                    .forks(1)
                    .mode(Mode.AverageTime)
                    .timeUnit(TimeUnit.NANOSECONDS)
                    .result(resultFile)
                    .resultFormat(ResultFormatType.JSON)
                    .build();

            new Runner(opt).run();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Benchmark failed for " + benchmark.clazz().getSimpleName(), e);
        }
    }
}
