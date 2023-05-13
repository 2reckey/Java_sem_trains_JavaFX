package com.trains.trains;

import com.trains.trains.Other.DataBase;

public abstract class Controller{
    DataBase dataBase=new DataBase();

    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public DataBase getDataBase() {
        return dataBase;
    }

    public void start(){}
}
