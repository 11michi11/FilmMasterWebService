package com.michi.imdbservice.domain.persistance;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.michi.imdbservice.domain.Film;
import com.michi.imdbservice.domain.FilmDetailed;


/*
Class generated from JSON got from OMDB API
It is used to deserialize JSON to Object and further to convert to domain objects.
It has all the attributes the JSON from OMDB API supplies
 */

public class OmdbDetailedFilm {

    @SerializedName("Title")
    @Expose
    public String title;
    @SerializedName("Year")
    @Expose
    public String year;
    @SerializedName("Rated")
    @Expose
    public String rated;
    @SerializedName("Released")
    @Expose
    public String released;
    @SerializedName("Runtime")
    @Expose
    public String runtime;
    @SerializedName("Genre")
    @Expose
    public String genre;
    @SerializedName("Director")
    @Expose
    public String director;
    @SerializedName("Writer")
    @Expose
    public String writer;
    @SerializedName("Actors")
    @Expose
    public String actors;
    @SerializedName("Plot")
    @Expose
    public String plot;
    @SerializedName("Language")
    @Expose
    public String language;
    @SerializedName("Country")
    @Expose
    public String country;
    @SerializedName("Awards")
    @Expose
    public String awards;
    @SerializedName("Poster")
    @Expose
    public String poster;
    @SerializedName("Ratings")
    @Expose
    public List<Rating> ratings = null;
    @SerializedName("Metascore")
    @Expose
    public String metascore;
    @SerializedName("imdbRating")
    @Expose
    public String imdbRating;
    @SerializedName("imdbVotes")
    @Expose
    public String imdbVotes;
    @SerializedName("imdbID")
    @Expose
    public String imdbID;
    @SerializedName("Type")
    @Expose
    public String type;
    @SerializedName("DVD")
    @Expose
    public String dVD;
    @SerializedName("BoxOffice")
    @Expose
    public String boxOffice;
    @SerializedName("Production")
    @Expose
    public String production;
    @SerializedName("Website")
    @Expose
    public String website;
    @SerializedName("Response")
    @Expose
    public String response;

    public static OmdbDetailedFilm fromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, OmdbDetailedFilm.class);
    }

    public FilmDetailed toDetailedFilm(){
        return new FilmDetailed(imdbID, title, released, runtime, director, type, actors, plot, poster, imdbRating, year);
    }

    public Film toFilm(){
        return new Film(title, type, imdbID, poster, year);
    }

    @Override
    public String toString() {
        return "OmdbDetailedFilm{" +
                "title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", rated='" + rated + '\'' +
                ", released='" + released + '\'' +
                ", runtime='" + runtime + '\'' +
                ", genre='" + genre + '\'' +
                ", director='" + director + '\'' +
                ", writer='" + writer + '\'' +
                ", actors='" + actors + '\'' +
                ", plot='" + plot + '\'' +
                ", language='" + language + '\'' +
                ", country='" + country + '\'' +
                ", awards='" + awards + '\'' +
                ", poster='" + poster + '\'' +
                ", ratings=" + ratings +
                ", metascore='" + metascore + '\'' +
                ", imdbRating='" + imdbRating + '\'' +
                ", imdbVotes='" + imdbVotes + '\'' +
                ", imdbID='" + imdbID + '\'' +
                ", type='" + type + '\'' +
                ", dVD='" + dVD + '\'' +
                ", boxOffice='" + boxOffice + '\'' +
                ", production='" + production + '\'' +
                ", website='" + website + '\'' +
                ", response='" + response + '\'' +
                '}';
    }
}


class Rating {

    @SerializedName("Source")
    @Expose
    public String source;
    @SerializedName("Value")
    @Expose
    public String value;

    @Override
    public String toString() {
        return "Rating{" +
                "source='" + source + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}