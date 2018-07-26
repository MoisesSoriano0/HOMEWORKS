package com.example.admin.w5d5testfriday.presenter;

import com.example.admin.w5d5testfriday.model.data.SchoolDetail;
import com.example.admin.w5d5testfriday.model.data.Schools;

import java.util.ArrayList;

public interface Contract {


    interface View{

        void displaySchools(ArrayList<Schools> schools);


    }
     interface SchoolInfo
    {
         void displaySchoolInfo(SchoolDetail schoolDetail);

    }

     interface Presenter
    {
         void getSchools();
         void getSchoolInfo(String name);
         void attachView(Contract.View view);
    }

}
