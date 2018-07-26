package com.example.admin.w5d5testfriday.model.data.model;

public class SchoolSingleton {

    private static SchoolSingleton instance = null;


    String schoolName;
    String schoolCity;
    String faxNumber;
    String phoneNumber;

    private SchoolSingleton() {
    }

    public static SchoolSingleton getInstance(){
        if(instance == null){
            instance = new SchoolSingleton();
        }
        return  instance;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolCity() {
        return schoolCity;
    }

    public void setSchoolCity(String schoolCity) {
        this.schoolCity = schoolCity;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


}
