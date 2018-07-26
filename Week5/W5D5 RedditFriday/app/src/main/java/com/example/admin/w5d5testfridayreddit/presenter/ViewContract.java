package com.example.admin.w5d5testfridayreddit.presenter;

import com.example.admin.w5d5testfridayreddit.model.Child;

import java.util.ArrayList;

public interface ViewContract {

     interface View{
        void displayResults(ArrayList<Child> results);

    }

     interface Presenter{
        void getResult(String query);

    }

}
