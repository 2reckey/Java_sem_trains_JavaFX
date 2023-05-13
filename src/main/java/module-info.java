module com.trains.trains {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.trains.trains to javafx.fxml;
    exports com.trains.trains;
    exports com.trains.trains.Other;
    opens com.trains.trains.Other to javafx.fxml;
}