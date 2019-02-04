package com.michi.imdbservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "detailed_films")
public class FilmDetailed {

    @Id
    public String imdbID;
    @Column
    public String title;
    @Column
    public String realisedDate;
    @Column
    public String runtime;
    @Column
    public String director;
    @Column
    public String type;
    @Column
    public String actors;
    @Column
    public String plot;
    @Column
    public String posterURL;
    @Column
    public String imdbRating;
    @Column
    public String year;

    public FilmDetailed(){}


    public FilmDetailed(String imdbID, String title, String realisedDate, String runtime, String director, String type, String actors, String plot, String posterURL, String imdbRating, String year) {
        this.imdbID = imdbID;
        this.title = title;
        this.realisedDate = realisedDate;
        this.runtime = runtime;
        this.director = director;
        this.type = type;
        this.actors = actors;
        this.plot = plot;
        this.posterURL = posterURL;
        this.imdbRating = imdbRating;
        this.year = year;
    }

    public Film toFilm(){
        return new Film(title, type, imdbID, posterURL, year);
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRealisedDate() {
        return realisedDate;
    }

    public void setRealisedDate(String realisedDate) {
        this.realisedDate = realisedDate;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getPosterURL() {
        return posterURL;
    }

    public void setPosterURL(String posterURL) {
        this.posterURL = posterURL;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "FilmDetailed{" +
                "imdbID='" + imdbID + '\'' +
                ", title='" + title + '\'' +
                ", realisedDate='" + realisedDate + '\'' +
                ", runtime='" + runtime + '\'' +
                ", director='" + director + '\'' +
                ", type='" + type + '\'' +
                ", actors='" + actors + '\'' +
                ", plot='" + plot + '\'' +
                ", posterURL='" + posterURL + '\'' +
                ", imdbRating='" + imdbRating + '\'' +
                ", year='" + year + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FilmDetailed that = (FilmDetailed) o;

        if (imdbID != null ? !imdbID.equals(that.imdbID) : that.imdbID != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (realisedDate != null ? !realisedDate.equals(that.realisedDate) : that.realisedDate != null) return false;
        if (runtime != null ? !runtime.equals(that.runtime) : that.runtime != null) return false;
        if (director != null ? !director.equals(that.director) : that.director != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (actors != null ? !actors.equals(that.actors) : that.actors != null) return false;
        if (plot != null ? !plot.equals(that.plot) : that.plot != null) return false;
        if (posterURL != null ? !posterURL.equals(that.posterURL) : that.posterURL != null) return false;
        if (imdbRating != null ? !imdbRating.equals(that.imdbRating) : that.imdbRating != null) return false;
        return year != null ? year.equals(that.year) : that.year == null;
    }

    @Override
    public int hashCode() {
        int result = imdbID != null ? imdbID.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (realisedDate != null ? realisedDate.hashCode() : 0);
        result = 31 * result + (runtime != null ? runtime.hashCode() : 0);
        result = 31 * result + (director != null ? director.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (actors != null ? actors.hashCode() : 0);
        result = 31 * result + (plot != null ? plot.hashCode() : 0);
        result = 31 * result + (posterURL != null ? posterURL.hashCode() : 0);
        result = 31 * result + (imdbRating != null ? imdbRating.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        return result;
    }
}
