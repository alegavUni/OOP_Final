package com.github.alegavuni.matte1cat.javabenchmarks.adapter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class JmhResultLoader {

    public static List<JmhResultEntry> load(File jsonFile) throws IOException {
        Gson gson = new Gson();
        Type listType = new TypeToken<List<JmhResultEntry>>() {}.getType();
        try (FileReader reader = new FileReader(jsonFile)) {
            return gson.fromJson(reader, listType);
        }
    }
}
