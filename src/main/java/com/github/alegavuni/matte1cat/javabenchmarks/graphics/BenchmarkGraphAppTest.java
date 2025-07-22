package com.github.alegavuni.matte1cat.javabenchmarks.graphics;

import com.github.alegavuni.matte1cat.javabenchmarks.benchmarks.AccessLatencyBenchmark;
import com.github.alegavuni.matte1cat.javabenchmarks.benchmarks.CollectionsBenchmark;
import com.github.alegavuni.matte1cat.javabenchmarks.benchmarks.HashingBenchmark;
import com.github.alegavuni.matte1cat.javabenchmarks.adapter.JmhResultEntry;
import com.github.alegavuni.matte1cat.javabenchmarks.adapter.JmhResultLoader;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.results.format.ResultFormatType;

import java.io.*;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BenchmarkGraphAppTest extends Application {

    private static final Logger LOGGER = Logger.getLogger(BenchmarkGraphAppTest.class.getName());

    private final StackPane chartContainer = new StackPane();
    private String lastLoadedJsonRaw = null;
    private List<JmhResultEntry> lastParsedResults = null;

    @Override
    public void start(Stage stage) {
        stage.setTitle("Java Benchmark Viewer");

        ComboBox<String> categorySelector = new ComboBox<>();
        categorySelector.getItems().addAll("Collections", "Latency", "Hashing");
        categorySelector.setValue("Collections");

        Button runButton = new Button("Run Benchmark");
        Button processButton = new Button("Process Result File");
        Button viewJsonButton = new Button("View Loaded JSON");
        viewJsonButton.setDisable(true);

        ToggleButton barChartToggle = new ToggleButton("Bar Chart View");

        // Create subfolders if they don't exist
        new File("results/latency").mkdirs();
        new File("results/collections").mkdirs();
        new File("results/hashing").mkdirs();

        runButton.setOnAction(e -> {
            String category = categorySelector.getValue();
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
            String resultFileName = "results/" + category.toLowerCase() + "/" + category.toLowerCase() + "_" + timestamp + ".json";

            String benchmarkClassPattern = switch (category) {
                case "Collections" -> ".*CollectionsBenchmark.*";
                case "Latency" -> ".*AccessLatencyBenchmark.*";
                case "Hashing" -> ".*HashingBenchmarks.*";
                default -> throw new IllegalArgumentException("Unknown category: " + category);
            };

            new Thread(() -> {
                try {
                    Options opt = switch (category) {
                        case "Collections" -> new OptionsBuilder()
                                .include(CollectionsBenchmark.class.getName())
                                .warmupIterations(2)
                                .warmupTime(org.openjdk.jmh.runner.options.TimeValue.milliseconds(500))
                                .measurementIterations(3)
                                .measurementTime(org.openjdk.jmh.runner.options.TimeValue.milliseconds(500))
                                .forks(1)
                                .mode(org.openjdk.jmh.annotations.Mode.AverageTime)
                                .timeUnit(java.util.concurrent.TimeUnit.NANOSECONDS)
                                .result(resultFileName)
                                .resultFormat(ResultFormatType.JSON)
                                .build();
                        case "Latency" -> new OptionsBuilder()
                                .include(AccessLatencyBenchmark.class.getName())
                                .warmupIterations(2)
                                .warmupTime(org.openjdk.jmh.runner.options.TimeValue.milliseconds(500))
                                .measurementIterations(3)
                                .measurementTime(org.openjdk.jmh.runner.options.TimeValue.milliseconds(500))
                                .forks(1)
                                .mode(org.openjdk.jmh.annotations.Mode.AverageTime)
                                .timeUnit(java.util.concurrent.TimeUnit.NANOSECONDS)
                                .result(resultFileName)
                                .resultFormat(ResultFormatType.JSON)
                                .build();
                        case "Hashing" -> new OptionsBuilder()
                                .include(HashingBenchmark.class.getName())
                                .warmupIterations(2)
                                .warmupTime(org.openjdk.jmh.runner.options.TimeValue.milliseconds(500))
                                .measurementIterations(3)
                                .measurementTime(org.openjdk.jmh.runner.options.TimeValue.milliseconds(500))
                                .forks(1)
                                .mode(org.openjdk.jmh.annotations.Mode.AverageTime)
                                .timeUnit(java.util.concurrent.TimeUnit.NANOSECONDS)
                                .result(resultFileName)
                                .resultFormat(ResultFormatType.JSON)
                                .build();
                        default -> throw new IllegalArgumentException("Unknown category: " + category);
                    };

                    new Runner(opt).run();

                    File resultFile = new File(resultFileName);
                    if (resultFile.exists()) {
                        lastLoadedJsonRaw = Files.readString(resultFile.toPath());
                        lastParsedResults = JmhResultLoader.load(resultFile);
                        javafx.application.Platform.runLater(() -> {
                            renderJsonChart(lastParsedResults, barChartToggle.isSelected());
                            viewJsonButton.setDisable(false);
                        });
                    }

                } catch (IOException | RunnerException ex) {
                    LOGGER.log(Level.SEVERE, "Failed to run benchmark", ex);
                }
            }).start();
        });

        processButton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Select Benchmark Result File (.json)");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON Files", "*.json"));
            File file = fileChooser.showOpenDialog(stage);
            if (file != null) {
                try {
                    lastLoadedJsonRaw = Files.readString(file.toPath());
                    lastParsedResults = JmhResultLoader.load(file);
                    renderJsonChart(lastParsedResults, barChartToggle.isSelected());
                    viewJsonButton.setDisable(false);
                } catch (IOException ex) {
                    LOGGER.log(Level.SEVERE, "Failed to load JSON file", ex);
                }
            }
        });

        viewJsonButton.setOnAction(e -> {
            if (lastLoadedJsonRaw != null) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Loaded JSON File");
                alert.setHeaderText("Raw JSON Content");

                TextArea textArea = new TextArea(lastLoadedJsonRaw);
                textArea.setEditable(false);
                textArea.setWrapText(false);
                textArea.setMaxWidth(Double.MAX_VALUE);
                textArea.setMaxHeight(Double.MAX_VALUE);

                alert.getDialogPane().setContent(textArea);
                alert.getDialogPane().setPrefSize(800, 600);
                alert.showAndWait();
            }
        });

        barChartToggle.setOnAction(e -> {
            if (lastParsedResults != null) {
                renderJsonChart(lastParsedResults, barChartToggle.isSelected());
            }
        });

        HBox buttonBox = new HBox(10, runButton, processButton, viewJsonButton, barChartToggle);
        VBox topControls = new VBox(10, categorySelector, buttonBox);
        BorderPane root = new BorderPane();
        root.setTop(topControls);
        root.setCenter(chartContainer);

        Scene scene = new Scene(root, 1000, 600);
        stage.setScene(scene);
        stage.show();
    }

    private void renderJsonChart(List<JmhResultEntry> results, boolean isBarChart) {
        boolean isHorizontalBar = isBarChart;

        Map<String, Map<String, Double>> groupedData = new LinkedHashMap<>();
        Set<String> allBenchmarks = new LinkedHashSet<>();
        Set<String> allSizes = new TreeSet<>(Comparator.comparingInt(s -> {
            try {
                return Integer.parseInt(s.replaceAll("[^0-9]", ""));
            } catch (NumberFormatException e) {
                return Integer.MAX_VALUE;
            }
        }));

        for (JmhResultEntry entry : results) {
            String benchName = entry.benchmark.substring(entry.benchmark.lastIndexOf('.') + 1);
            String size = "default";

            if (entry.params != null && entry.params.containsKey("size")) {
                size = entry.params.get("size");
            } else {
                String[] parts = benchName.split("_");
                if (parts.length > 1) size = parts[parts.length - 1];
            }

            if (isHorizontalBar) {
                groupedData.computeIfAbsent(size, k -> new LinkedHashMap<>()).put(benchName, entry.primaryMetric.score);
                allBenchmarks.add(benchName);
                allSizes.add(size);
            } else {
                groupedData.computeIfAbsent(benchName, k -> new LinkedHashMap<>()).put(size, entry.primaryMetric.score);
                allSizes.add(size);
            }
        }

        final Axis xAxis;
        final Axis yAxis;
        final XYChart<?, ?> chart;

        if (isHorizontalBar) {
            xAxis = new NumberAxis();
            xAxis.setLabel("Score (ns/op)");
            yAxis = new CategoryAxis();
            yAxis.setLabel("Benchmark");
            ((CategoryAxis) yAxis).setCategories(FXCollections.observableArrayList(allBenchmarks));
            chart = new BarChart<>(xAxis, yAxis);
        } else {
            xAxis = new CategoryAxis();
            xAxis.setLabel("Input Size");
            ((CategoryAxis) xAxis).setCategories(FXCollections.observableArrayList(allSizes));
            yAxis = new NumberAxis();
            yAxis.setLabel("Score (ns/op)");
            chart = new LineChart<>(xAxis, yAxis);
        }

        chart.setTitle("Benchmark Results");

        for (Map.Entry<String, Map<String, Double>> entry : groupedData.entrySet()) {
            XYChart.Series series = new XYChart.Series<>();
            series.setName(entry.getKey());

            Map<String, Double> dataPoints = entry.getValue();
            List<String> categories = isHorizontalBar ? new ArrayList<>(allBenchmarks) : new ArrayList<>(allSizes);

            for (String label : categories) {
                if (dataPoints.containsKey(label)) {
                    if (isHorizontalBar) {
                        series.getData().add(new XYChart.Data<>(dataPoints.get(label), label));
                    } else {
                        series.getData().add(new XYChart.Data<>(label, dataPoints.get(label)));
                    }
                }
            }

            chart.getData().add(series);
        }

        chartContainer.getChildren().setAll(chart);

        chart.layout();
        Platform.runLater(() -> {
            for (Object rawSeries : chart.getData()) {
                XYChart.Series<?, ?> series = (XYChart.Series<?, ?>) rawSeries;
                for (Object rawData : series.getData()) {
                    XYChart.Data<?, ?> data = (XYChart.Data<?, ?>) rawData;
                    Node node = data.getNode();
                    if (node instanceof StackPane bar) {
                        String value;
                        if (isHorizontalBar) {
                            value = String.format("%.2f", ((Number) data.getXValue()).doubleValue());
                        } else {
                            value = String.format("%.2f", ((Number) data.getYValue()).doubleValue());
                        }
                        Label label = new Label(value);
                        label.setStyle("-fx-font-size: 10px; -fx-text-fill: black;");
                        bar.getChildren().add(label);

                        if (isHorizontalBar) {
                            label.setTranslateX(10);
                        } else {
                            label.setTranslateY(-15);
                            label.setTranslateX(5);
                        }
                    }
                }
            }
        });
    }


    public static void main(String[] args) {
        launch();
    }
}
