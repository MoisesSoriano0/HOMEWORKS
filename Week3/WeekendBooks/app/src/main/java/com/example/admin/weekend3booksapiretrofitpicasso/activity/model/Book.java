package com.example.admin.weekend3booksapiretrofitpicasso.activity.model;

import com.google.gson.annotations.SerializedName;

public class Book {

    @SerializedName("volumeInfo")
    private BookInfo volumeInfo;

    public Book(BookInfo volumeInfo) {
        this.volumeInfo = volumeInfo;
    }

    public BookInfo getVolumeInfo() {
        return volumeInfo;
    }

    public void setVolumeInfo(BookInfo volumeInfo) {
        this.volumeInfo = volumeInfo;
    }

}
