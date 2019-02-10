package com.michi.imdbservice.domain;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import lombok.*;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "film")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@EqualsAndHashCode
@Getter
public class Film extends ResourceSupport {

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

}
