package com.trains.trains;

import com.trains.trains.Other.Const;
import com.trains.trains.Other.Train;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Time;
import java.time.LocalDate;

public class AddScheduleController extends Controller{

    @FXML
    private TextField from;

    @FXML
    private DatePicker fromDate;

    @FXML
    private TextField fromTime;

    @FXML
    private TableColumn<Train, String> name;

    @FXML
    private TextField price;

    @FXML
    private TableView<Train> table;

    @FXML
    private TextField to;

    @FXML
    private DatePicker toDate;

    @FXML
    private TextField toTime;

    @FXML
    void addSchedule(ActionEvent event) throws IOException {
        int trainId;
        try {
            Train selectedTrain = table.getSelectionModel().getSelectedItem();
            trainId = selectedTrain.getId();
        } catch (Exception e) {
            return;
        }
        LocalDate fromDateValue= fromDate.getValue();
        LocalDate toDateValue= toDate.getValue();
        Time fromTimeValue= Time.valueOf(fromTime.getText().trim());
        Time toTimeValue= Time.valueOf(toTime.getText().trim());
        String from =this.from.getText().trim();
        String to = this.to.getText().trim();
        int price = Integer.parseInt(this.price.getText().trim());

        String update = "INSERT INTO flights (origin_city, destination_city, departure_date, departure_time, arrival_date, arrival_time, base_price, train_id) " +
                "VALUES ('"+from+"', '"+to+"', '"+fromDateValue+"', '"+fromTimeValue+"', '"+toDateValue+"', '"+fromTimeValue+"', '"+price+"', '"+trainId+"');";

        getDataBase().updateData(update);

        toHome(event);

    }

    @FXML
    void toHome(ActionEvent event) throws IOException {
        Const.ReplaceView(event,"HomeView.fxml",getDataBase());
    }

    @Override
    public void start() {
        name.setCellValueFactory(new PropertyValueFactory<>("name"));

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
