package com.example.admin.dailytwo;

public class TagIt {
    public static String with(Object object){
        return object.getClass().getSimpleName() + "_TAG";
    }
}

