package com.trains.trains;

import com.trains.trains.Other.Const;
import com.trains.trains.Other.Train;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.sql.ResultSet;

public class TrainController extends Controller{

    @FXML
    private TableColumn<Train, Integer> cars;

    @FXML
    private TableColumn<Train, String> name;

    @FXML
    private TableColumn<Train, Integer> seats;

    @FXML
    private TableColumn<Train, String> type;

    @FXML
    private TableView<Train> table;

    @FXML
    void toHome(ActionEvent event) throws IOException {
        Const.ReplaceView(event,"HomeView.fxml",getDataBase());
    }

    @Override
    public void start() {
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        cars.setCellValueFactory(new PropertyValueFactory<>("cars"));
        seats.setCellValueFactory(new PropertyValueFactory<>("seats"));

        ObservableList<Train> train_list = FXCollections.observableArrayList();

        String select = "SELECT * FROM trains;";

        try {
            ResultSet reSet = getDataBase().getReSet(select);
            while (reSet.next()) train_list.add(new Train(reSet));
        } catch (Exception e) {
            System.out.println("Ошибка при получении данных");
        }

        table.setItems(train_list);
    }
}
