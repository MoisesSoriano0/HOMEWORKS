package com.example.admin.moviedbapi.model;

public class Movie {

    private static Movie instance;

    private String movieCover;
    private String movieTitle;
    private String movieOverview;
    private String movieRating;

    private Movie()
    {

    }

    public static Movie getInstance()
    {
        if (instance == null)
        {
            instance = new Movie();
        }

        return instance;
    }

    public String getMovieCover() {
        return movieCover;
    }

    public void setMovieCover(String movieCover) {
        this.movieCover = movieCover;
    }

    public static void setInstance(Movie instance) {
        Movie.instance = instance;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieOverview() {
        return movieOverview;
    }

    public void setMovieOverview(String movieOverview) {
        this.movieOverview = movieOverview;
    }

    public String getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(String movieRating) {
        this.movieRating = movieRating;
    }
}
