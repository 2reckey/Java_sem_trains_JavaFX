package com.trains.trains.Other;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

public class Flight {
    private String from;
    private String to;
    private String trainName;
    private Date fromDate;
    private Date toDate;
    private Time fromTime;
    private Time toTime;
    private int price;


    public Flight(ResultSet resultSet) throws SQLException {
        trainName = resultSet.getString(10);
        from = resultSet.getString(2);
        to = resultSet.getString(3);
        fromDate = resultSet.getDate(4);
        toDate = resultSet.getDate(6);
        fromTime = resultSet.getTime(5);
        toTime = resultSet.getTime(7);
        price = resultSet.getInt(8);
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getTrainName() {
        return trainName;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public Time getFromTime() {
        return fromTime;
    }

    public Time getToTime() {
        return toTime;
    }

    public int getPrice() {
        return price;
    }
}
