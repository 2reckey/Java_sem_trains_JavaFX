package com.trains.trains;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("HomeView.fxml"));
        Scene scene = new Scene(loader.load(), 700, 400);
        stage.setTitle("trains");
        stage.setScene(scene);
        stage.setResizable(false);
        Controller controller = loader.getController();
        controller.start();
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}