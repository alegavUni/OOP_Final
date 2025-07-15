package com.github.alegavuni.matte1cat.javabenchmarks.adapter;

import java.util.Map;

public class JmhResultEntry {
    public String benchmark;
    public String mode;
    public int threads;
    //public int forks;
    //public int warmupIterations;
    //public int measurementIterations;
    public PrimaryMetric primaryMetric;
    public Map<String, String> params;

    public static class PrimaryMetric {
        public double score;
        //public double scoreError;
        //public String scoreUnit;
    }
}
