package com.trains.trains;

import com.trains.trains.Other.Const;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AddTrainController extends Controller{

    @FXML
    private TextField cars;

    @FXML
    private TextField name;

    @FXML
    private TextField seats;

    @FXML
    private TextField type;

    @FXML
    void addTrain(ActionEvent event) throws IOException {

        String name = this.name.getText().trim();
        if (name.equals("")) {
            return;
        }
        String type = this.type.getText().trim();
        if (type.equals("")) {
            return;
        }
        int cars;
        try {
            cars = Integer.parseInt(this.cars.getText());
        } catch (Exception e) {
            return;
        }
        int seats;
        try {
            seats = Integer.parseInt(this.seats.getText());
        } catch (Exception e) {
            return;
        }

        String update = "INSERT INTO trains (train_name, train_type, num_cars, num_seats) " +
                "VALUES ('" + name + "', '" + type + "', " + cars + ", " + seats + ");";

        getDataBase().updateData(update);

        toHome(event);
    }

    @FXML
    void toHome(ActionEvent event) throws IOException {
        Const.ReplaceView(event,"HomeView.fxml",getDataBase());
    }

}
