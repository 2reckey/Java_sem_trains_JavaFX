package com.trains.trains;

import com.trains.trains.Other.Const;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class HomeController extends Controller{

    @FXML
    void addSchedule(ActionEvent event) throws IOException {
        Const.ReplaceView(event,"AddScheduleView.fxml",getDataBase());

    }

    @FXML
    void addTrain(ActionEvent event) throws IOException {
        Const.ReplaceView(event,"AddTrainView.fxml",getDataBase());
    }

    @FXML
    void toSchedule(ActionEvent event) throws IOException {
        Const.ReplaceView(event,"ScheduleView.fxml",getDataBase());
    }

    @FXML
    void toTrains(ActionEvent event) throws IOException {
        Const.ReplaceView(event,"TrainsView.fxml", getDataBase());
    }

    @Override
    public void start() {
        getDataBase().setConnection();
    }
}
