package com.trains.trains;

import com.trains.trains.Other.Const;
import com.trains.trains.Other.Flight;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Time;

public class ScheduleController extends Controller{

    @FXML
    private TableColumn<Flight, String> from;

    @FXML
    private TableColumn<Flight, Date> fromDate;

    @FXML
    private TableColumn<Flight, Time> fromTime;

    @FXML
    private TableColumn<Flight, Integer> price;

    @FXML
    private TableView<Flight> table;

    @FXML
    private TableColumn<Flight, String> to;

    @FXML
    private TableColumn<Flight, Date> toDate;

    @FXML
    private TableColumn<Flight, Time> toTime;

    @FXML
    private TableColumn<Flight, String> trainName;

    @FXML
    void toHome(ActionEvent event) throws IOException {
        Const.ReplaceView(event,"HomeView.fxml",getDataBase());
    }

    @Override
    public void start() {
        from.setCellValueFactory(new PropertyValueFactory<>("from"));
        to.setCellValueFactory(new PropertyValueFactory<>("to"));
        trainName.setCellValueFactory(new PropertyValueFactory<>("trainName"));
        fromDate.setCellValueFactory(new PropertyValueFactory<>("fromDate"));
        fromTime.setCellValueFactory(new PropertyValueFactory<>("fromTime"));
        toTime.setCellValueFactory(new PropertyValueFactory<>("toTime"));
        toDate.setCellValueFactory(new PropertyValueFactory<>("toDate"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));

        ObservableList<Flight> schedule_list = FXCollections.observableArrayList();

        String select = "SELECT f.*, t.train_name FROM flights f JOIN trains t ON f.train_id=t.train_id;";

        try {
            ResultSet reSet = getDataBase().getReSet(select);
            while (reSet.next()) schedule_list.add(new Flight(reSet));
        } catch (Exception e) {
            System.out.println("Ошибка при получении данных");
        }

        table.setItems(schedule_list);
    }
}
