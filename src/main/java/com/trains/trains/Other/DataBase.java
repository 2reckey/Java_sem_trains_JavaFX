package com.trains.trains.Other;

import java.sql.*;


public class DataBase extends Const {
    private Connection connection;

    private final String URL = "jdbc:mysql://" + dbHost + dbPort + dbName;

    public void setConnection() {
        try {
            connection = DriverManager.getConnection(URL, dbUser, dbPass);
        } catch (SQLException e) {
            System.out.println("Ошибка подключения к серверу");
        }
    }

    public ResultSet getReSet(String select) {
        try {
            Statement statement = connection.createStatement();
            return statement.executeQuery(select);
        } catch (SQLException e) {
            System.out.println("Ошибка при получении данных");
            return null;
        }
    }

    public void updateData(String update) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(update);
        } catch (SQLException e) {
            System.out.println("Ошибка при обновлении данных");
        }
    }
}