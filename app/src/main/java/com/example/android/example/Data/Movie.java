package com.example.android.example.Data;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Movie implements Parcelable {

    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
    private String title;
    private String poster;
    private String overview;
    private String userRating;
    private String releaseDate;
    private String movieID;

    /**
     * @param title
     * @param poster
     * @param overview
     * @param userRating
     * @param releaseDate
     * @param movieID
     */
    public Movie(String title, String poster, String overview, String userRating,
                 String releaseDate, String movieID) {
        this.title = title;
        this.poster = poster;
        this.overview = overview;
        this.userRating = userRating;
        this.releaseDate = releaseDate;
        this.movieID = movieID;
    }

    /**
     * @param source
     */
    public Movie(Parcel source) {
        this.title = source.readString();
        this.poster = source.readString();
        this.overview = source.readString();
        this.userRating = source.readString();
        this.releaseDate = source.readString();
        this.movieID = source.readString();
    }

    /**
     * @return
     */
    public String getOverview() {

        return overview;
    }


    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getPoster() {

        return poster;
    }


    public String getUserRating() {

        return userRating;
    }


    public String getReleaseDate() {

        return convertDateString(releaseDate);
    }

    public String getmovieID() {
        return movieID;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(poster);
        dest.writeString(overview);
        dest.writeString(userRating);
        dest.writeString(releaseDate);
        dest.writeString(movieID);
    }

    private String convertDateString(String dateString) {
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd", Locale.US).parse(dateString);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.MEDIUM);
        return dateFormatter.format(date);
    }


}
