package com.github.alegavuni.matte1cat.javabenchmarks.adapter;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

public class JmhResultEntry {
    public String benchmark;
    public String mode;
    public int threads;
    public PrimaryMetric primaryMetric;
    public Map<String, String> params;

    public static class PrimaryMetric {
        public double score;

        @SerializedName("scoreError")
        public double scoreError;
    }
}

