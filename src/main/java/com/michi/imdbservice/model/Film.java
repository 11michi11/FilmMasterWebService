package com.michi.imdbservice.model;

import javax.persistence.*;

@Entity
@Table(name = "film")
public class Film {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "type")
    private String type;
    @Column(name = "imdbid")
    private String imdbID;
    @Column(name = "posterurl")
    private String posterURL;
    @Column(name = "year")
    private String year;


    public Film() { }

    public Film(String title, String type, String imdbID, String posterURL, String year) {
        this.title = title;
        this.type = type;
        this.imdbID = imdbID;
        this.posterURL = posterURL;
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
                "id=" + id +
                ", title='" + title + '\'' +
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

        if (id != null ? !id.equals(film.id) : film.id != null) return false;
        if (title != null ? !title.equals(film.title) : film.title != null) return false;
        if (type != null ? !type.equals(film.type) : film.type != null) return false;
        if (imdbID != null ? !imdbID.equals(film.imdbID) : film.imdbID != null) return false;
        if (posterURL != null ? !posterURL.equals(film.posterURL) : film.posterURL != null) return false;
        return year != null ? year.equals(film.year) : film.year == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (imdbID != null ? imdbID.hashCode() : 0);
        result = 31 * result + (posterURL != null ? posterURL.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        return result;
    }
}
