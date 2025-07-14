package com.github.alegavuni.matte1cat.javabenchmarks;

import com.github.alegavuni.matte1cat.javabenchmarks.latency.AccessLatency;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class Main {
    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder()
                .include(AccessLatency.class.getSimpleName())
                .build();

        new Runner(opt).run();
    }
}
