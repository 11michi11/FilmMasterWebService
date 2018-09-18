package com.michi.imdbservice.model;

public class FilmDetailed {

    public String title;
    public String realisedDate;
    public String runtime;
    public String director;
    public String actors;
    public String plot;
    public String posterURL;
    public String imdbRating;
    public String imdbID;

    public FilmDetailed(String title, String realisedDate, String runtime, String director, String actors, String plot, String posterURL, String imdbRating, String imdbID) {
        this.title = title;
        this.realisedDate = realisedDate;
        this.runtime = runtime;
        this.director = director;
        this.actors = actors;
        this.plot = plot;
        this.posterURL = posterURL;
        this.imdbRating = imdbRating;
        this.imdbID = imdbID;
    }

    @Override
    public String toString() {
        return "FilmDetailed{" +
                "title='" + title + '\'' +
                ", realisedDate='" + realisedDate + '\'' +
                ", runtime='" + runtime + '\'' +
                ", director='" + director + '\'' +
                ", actors='" + actors + '\'' +
                ", plot='" + plot + '\'' +
                ", posterURL='" + posterURL + '\'' +
                ", imdbRating='" + imdbRating + '\'' +
                ", imdbID='" + imdbID + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FilmDetailed that = (FilmDetailed) o;

        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (realisedDate != null ? !realisedDate.equals(that.realisedDate) : that.realisedDate != null) return false;
        if (runtime != null ? !runtime.equals(that.runtime) : that.runtime != null) return false;
        if (imdbID != null ? !imdbID.equals(that.imdbID) : that.imdbID != null) return false;
        if (posterURL != null ? !posterURL.equals(that.posterURL) : that.posterURL != null) return false;
        if (director != null ? !director.equals(that.director) : that.director != null) return false;
        if (actors != null ? !actors.equals(that.actors) : that.actors != null) return false;
        if (plot != null ? !plot.equals(that.plot) : that.plot != null) return false;
        return imdbRating != null ? imdbRating.equals(that.imdbRating) : that.imdbRating == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (realisedDate != null ? realisedDate.hashCode() : 0);
        result = 31 * result + (runtime != null ? runtime.hashCode() : 0);
        result = 31 * result + (imdbID != null ? imdbID.hashCode() : 0);
        result = 31 * result + (posterURL != null ? posterURL.hashCode() : 0);
        result = 31 * result + (director != null ? director.hashCode() : 0);
        result = 31 * result + (actors != null ? actors.hashCode() : 0);
        result = 31 * result + (plot != null ? plot.hashCode() : 0);
        result = 31 * result + (imdbRating != null ? imdbRating.hashCode() : 0);
        return result;
    }
}
