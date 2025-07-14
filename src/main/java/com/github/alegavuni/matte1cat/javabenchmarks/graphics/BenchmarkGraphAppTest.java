package com.github.alegavuni.matte1cat.javabenchmarks.graphics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BenchmarkGraphAppTest extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Benchmark Viewer");

        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();

        xAxis.setLabel("Input Size");
        yAxis.setLabel("Execution Time (ms)");

        LineChart<String, Number> chart = new LineChart<>(xAxis, yAxis);
        chart.setTitle("Mock Benchmark");

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("ArrayList");
        series.getData().add(new XYChart.Data<>("1K", 10));
        series.getData().add(new XYChart.Data<>("10K", 25));
        series.getData().add(new XYChart.Data<>("100K", 75));

        chart.getData().add(series);

        BorderPane root = new BorderPane(chart);
        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

