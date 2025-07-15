package com.github.alegavuni.matte1cat.javabenchmarks.graphics;

import com.github.alegavuni.matte1cat.javabenchmarks.adapter.JmhResultEntry;
import com.github.alegavuni.matte1cat.javabenchmarks.adapter.JmhResultLoader;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BenchmarkGraphAppTest extends Application {

    private static final Logger LOGGER = Logger.getLogger(BenchmarkGraphAppTest.class.getName());
    private final StackPane chartContainer = new StackPane();
    private final ComboBox<String> testSelector = new ComboBox<>();

    // Category → Test options
    private final Map<String, List<String>> testsByCategory = Map.of(
            "Collections", List.of("ArrayList", "LinkedList", "HashSet", "TreeSet", "HashMap", "EnumSet", "Queue", "SortedSet"),
            "Caching", List.of("Sequential", "Random"),
            "Hashing", List.of("String", "Object/Primitive")
    );

    @Override
    public void start(Stage stage) {
        stage.setTitle("Java Benchmark Viewer");

        // CATEGORY SELECTOR
        ComboBox<String> categorySelector = new ComboBox<>();
        categorySelector.getItems().addAll("Collections", "Caching", "Hashing");
        categorySelector.setValue("Collections");

        // TEST SELECTOR
        testSelector.setPromptText("Select a test");

        categorySelector.setOnAction(event -> {
            String selectedCategory = categorySelector.getValue();
            updateTestSelector(selectedCategory);
        });

        testSelector.setOnAction(event -> {
            String category = categorySelector.getValue();
            String test = testSelector.getValue();
            if (test != null) updateChart(category, test);
        });

        // BUTTONS
        Button runButton = new Button("Run Benchmark");
        Button processButton = new Button("Process Result File");

        runButton.setOnAction(e -> {
            // Optional: use Runtime.getRuntime().exec(...) to trigger benchmark
            System.out.println("Benchmark run requested (stub)");
        });

        processButton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Select Benchmark Result File (.json)");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON Files", "*.json"));
            File file = fileChooser.showOpenDialog(stage);
            if (file != null) {
                try {
                    List<JmhResultEntry> results = JmhResultLoader.load(file);
                    renderJsonChart(results);
                } catch (IOException ex) {
                    LOGGER.log(Level.SEVERE, "Failed to load JSON file", ex);
                }
            }
        });

        HBox buttonBox = new HBox(10, runButton, processButton);
        VBox topControls = new VBox(10, categorySelector, testSelector, buttonBox);
        BorderPane root = new BorderPane();
        root.setTop(topControls);
        root.setCenter(chartContainer);

        updateTestSelector("Collections"); // default

        Scene scene = new Scene(root, 1000, 600);
        stage.setScene(scene);
        stage.show();
    }

    private void updateTestSelector(String category) {
        testSelector.getItems().clear();
        List<String> tests = testsByCategory.getOrDefault(category, Collections.emptyList());
        testSelector.getItems().addAll(tests);
        if (!tests.isEmpty()) {
            testSelector.setValue(tests.getFirst());
            updateChart(category, tests.getFirst());
        }
    }

    private void updateChart(String category, String test) {
        LineChart<String, Number> chart;
        switch (category) {
            case "Collections" -> chart = generateMockCollectionChart(test);
            case "Caching" -> chart = generateMockCachingChart(test);
            case "Hashing" -> chart = generateMockHashingChart(test);
            default -> throw new IllegalArgumentException("Unknown category: " + category);
        }
        chartContainer.getChildren().setAll(chart);
    }

    private LineChart<String, Number> generateMockCollectionChart(String collectionType) {
        double[] data = switch (collectionType) {
            case "ArrayList" -> new double[]{1000, 800, 500, 200};
            case "LinkedList" -> new double[]{900, 650, 400, 150};
            case "HashSet" -> new double[]{1100, 850, 600, 300};
            case "TreeSet" -> new double[]{950, 700, 450, 180};
            case "HashMap" -> new double[]{1200, 900, 700, 500};
            case "EnumSet" -> new double[]{1300, 1250, 1220, 1200};
            case "Queue" -> new double[]{800, 600, 400, 100};
            case "SortedSet" -> new double[]{1000, 720, 500, 250};
            default -> new double[]{0, 0, 0, 0};
        };
        return createLineChart(
                collectionType + " Performance",
                "Input Size",
                "Ops/ms",
                collectionType, data,
                new String[]{"1K", "10K", "100K", "1M"}
        );
    }

    private LineChart<String, Number> generateMockCachingChart(String test) {
        double[] data = switch (test) {
            case "Sequential" -> new double[]{90, 130, 170, 260, 400};
            case "Random" -> new double[]{150, 210, 320, 490, 720};
            default -> new double[]{0, 0, 0, 0, 0};
        };
        return createLineChart(
                test + " Access Latency",
                "Size",
                "Time (ns)",
                test, data,
                new String[]{"512", "4K", "16K", "64K", "1M"}
        );
    }

    private LineChart<String, Number> generateMockHashingChart(String test) {
        double[] data = switch (test) {
            case "String" -> new double[]{100, 130, 145, 150};
            case "Object/Primitive" -> new double[]{20, 22, 24, 26};
            default -> new double[]{0, 0, 0, 0};
        };
        return createLineChart(
                test + " Hashing Time",
                "Input",
                "Time (ns)",
                test, data,
                new String[]{"Short", "Med", "Long", "Huge"}
        );
    }

    private LineChart<String, Number> createLineChart(
            String title,
            String xLabel,
            String yLabel,
            String seriesName,
            double[] values,
            String[] labels
    ) {
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel(xLabel);

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel(yLabel);

        LineChart<String, Number> chart = new LineChart<>(xAxis, yAxis);
        chart.setTitle(title);

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName(seriesName);
        for (int i = 0; i < Math.min(values.length, labels.length); i++) {
            series.getData().add(new XYChart.Data<>(labels[i], values[i]));
        }

        chart.getData().add(series);
        return chart;
    }

    private void renderJsonChart(List<JmhResultEntry> results) {
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Params");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Score");

        LineChart<String, Number> chart = new LineChart<>(xAxis, yAxis);
        chart.setTitle("Imported Benchmark Results");

        Map<String, XYChart.Series<String, Number>> seriesMap = new HashMap<>();

        for (JmhResultEntry entry : results) {
            String benchName = entry.benchmark.substring(entry.benchmark.lastIndexOf('.') + 1);
            String paramLabel = entry.params != null && entry.params.containsKey("size")
                    ? entry.params.get("size")
                    : "default";

            XYChart.Series<String, Number> series = seriesMap.computeIfAbsent(benchName, k -> {
                XYChart.Series<String, Number> s = new XYChart.Series<>();
                s.setName(k);
                return s;
            });

            series.getData().add(new XYChart.Data<>(paramLabel, entry.primaryMetric.score));
        }

        chart.getData().addAll(seriesMap.values());
        chartContainer.getChildren().setAll(chart);
    }

    public static void main(String[] args) {
        launch();
    }
}
