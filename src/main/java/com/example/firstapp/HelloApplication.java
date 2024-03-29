package com.example.firstapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void init() throws InterruptedException {
        System.out.println("Before the app starts");
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(5000);
    }
    @Override
    public void start(Stage stage) throws Exception {
        System.out.println(Thread.currentThread().getName());
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20,20,20,20));
        root.setSpacing(20);
        Label text = new Label("");
        Button button = new Button("Click Me!");
        Button btnExit = new Button("Exit Expicitly");
        button.setOnAction(e -> text.setText("Welcome to JavaFX Application!"));
        btnExit.setOnAction(e -> Platform.exit());
        root.getChildren().addAll(text,button,btnExit);
        Scene scene = new Scene(root, 350,300);
        stage.setScene(scene);
        stage.setTitle("JavaFX Application");
        stage.show();
    }

    @Override
    public void stop(){
        System.out.println(Thread.currentThread().getName());
        System.out.println("Closing the Application");
    }

    public static void main(String[] args) {
        launch(); // 2 Threads 1. Java FX launcher 2. JavaFX application thread
    }
}