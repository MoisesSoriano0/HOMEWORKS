package com.example.admin.weekend3booksapiretrofitpicasso.activity.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class BookInfo {

    @SerializedName("title")
    private String title;

    @SerializedName("authors")
    private List<String> authors;

    @SerializedName("imageLinks")
    private Thumbnails imageLinks;

    public BookInfo(String title, List<String> authors, Thumbnails imageLinks) {
        this.title = title;
        this.authors = authors;
        this.imageLinks = imageLinks;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public Thumbnails getImageLinks() {
        return imageLinks;
    }

    public void setImageLinks(Thumbnails imageLinks) {
        this.imageLinks = imageLinks;
    }

    public class Thumbnails{

        @SerializedName("smallThumbnail")
        String smallThumbnail;

        @SerializedName("thumbnail")
        String thumbnail;

        public Thumbnails(String smallThumbnail, String thumbnail) {
            this.smallThumbnail = smallThumbnail;
            this.thumbnail = thumbnail;
        }

        public String getSmallThumbnail() {
            return smallThumbnail;
        }

        public void setSmallThumbnail(String smallThumbnail) {
            this.smallThumbnail = smallThumbnail;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }
    }
}
