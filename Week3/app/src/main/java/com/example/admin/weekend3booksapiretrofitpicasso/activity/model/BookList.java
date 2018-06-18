package com.example.admin.weekend3booksapiretrofitpicasso.activity.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class BookList {

    @SerializedName("items")
    private ArrayList<Book> bookArrayList;

    public ArrayList<Book> getBookArrayList() {
        return bookArrayList;
    }

    public void setBookArrayList(ArrayList<Book> bookArrayList) {
        this.bookArrayList = bookArrayList;
    }
}
