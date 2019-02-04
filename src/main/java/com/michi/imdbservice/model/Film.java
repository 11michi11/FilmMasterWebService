package com.michi.imdbservice.model;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "film")
public class Film {

    @Id
    @Column(name = "imdbid")
    private String imdbID;
    @Column(name = "title")
    @SerializedName("Title")
    private String title;
    @Column(name = "type")
    @SerializedName("Type")
    private String type;
    @Column(name = "posterurl")
    @SerializedName("Poster")
    private String posterURL;
    @Column(name = "year")
    @SerializedName("Year")
    private String year;

    public Film() {
    }

    public Film(String title, String type, String imdbID, String posterURL, String year) {
        this.title = title;
        this.type = type;
        this.imdbID = imdbID;
        this.posterURL = posterURL;
        this.year = year;
    }

    public static List<Film> fromJsonToList(String json) {
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
        JsonArray search = jsonObject.get("Search").getAsJsonArray();
        return gson.fromJson(search, new TypeToken<List<Film>>() {
        }.getType());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getPosterURL() {
        return posterURL;
    }

    public void setPosterURL(String posterURL) {
        this.posterURL = posterURL;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Film{" +
                "title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", imdbID='" + imdbID + '\'' +
                ", posterURL='" + posterURL + '\'' +
                ", year='" + year + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Film film = (Film) o;

        if (title != null ? !title.equals(film.title) : film.title != null) return false;
        if (type != null ? !type.equals(film.type) : film.type != null) return false;
        if (imdbID != null ? !imdbID.equals(film.imdbID) : film.imdbID != null) return false;
        if (posterURL != null ? !posterURL.equals(film.posterURL) : film.posterURL != null) return false;
        return year != null ? year.equals(film.year) : film.year == null;
    }

    @Override
    public int hashCode() {
        int result = (title != null ? title.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (imdbID != null ? imdbID.hashCode() : 0);
        result = 31 * result + (posterURL != null ? posterURL.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        return result;
    }
}
