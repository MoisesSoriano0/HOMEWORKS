package com.example.admin.w5d2fragmentsrecyclerview;


public class Car{

    String Model;
    String Type;
    String Year;

    public Car(String model, String type, String year) {
        Model = model;
        Type = type;
        Year = year;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }
}
