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

    //    @SerializedName("smallThumbnail")
//    private String urlThumbnail;
//    @SerializedName("title")
//    private String title;
//    @SerializedName("authors")
//    private String author;
//
//    public Book(String urlThumbnail, String title, String author) {
//        this.urlThumbnail = urlThumbnail;
//        this.title = title;
//        this.author = author;
//    }
//
//    public String getUrlThumbnail() {
//        return urlThumbnail;
//    }
//
//    public void setUrlThumbnail(String urlThumbnail) {
//        this.urlThumbnail = urlThumbnail;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(String author) {
//        this.author = author;
//    }
}
