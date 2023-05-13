package com.trains.trains.Other;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Train {
    private int id;
    private String name;
    private String type;
    private int cars;
    private int seats;

    public Train(ResultSet resultSet) throws SQLException {
        id = resultSet.getInt(1);
        name = resultSet.getString(2);
        type = resultSet.getString(3);
        cars = resultSet.getInt(4);
        seats = resultSet.getInt(5);
    }


    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getCars() {
        return cars;
    }

    public int getSeats() {
        return seats;
    }

    public int getId() {
        return id;
    }
}
