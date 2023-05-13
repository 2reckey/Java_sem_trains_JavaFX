package com.trains.trains.Other;

import com.trains.trains.Controller;
import com.trains.trains.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Const {
    protected String dbHost = "localhost"; //Адрес хоста
    protected String dbPort = ":3306"; //Порт (двоеточие не убирать)
    protected String dbUser = "root"; //Имя пользователя для подключения к БД
    protected String dbPass = "root"; //Пароль
    protected String dbName = "/trains"; //Название таблицы

    public static void ReplaceView(ActionEvent event, String View, DataBase dataBase) throws IOException {
        FXMLLoader new_loader = new FXMLLoader(MainApp.class.getResource(View));
        Stage stage = getStage(event);
        Parent new_root = new_loader.load();
        Scene new_scene = new Scene(new_root);

        stage.setScene(new_scene);
        connectDB(new_loader, dataBase);
        stage.show();
    }

    public static Stage getStage(ActionEvent event) {
        return (Stage) ((Node) event.getSource()).getScene().getWindow();
    }

    public static void connectDB(FXMLLoader loader, DataBase dataBase) {
        Controller controller = loader.getController();
        controller.setDataBase(dataBase);
        controller.start();
    }
}
