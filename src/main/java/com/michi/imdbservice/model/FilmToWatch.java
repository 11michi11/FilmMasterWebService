package com.michi.imdbservice.model;

import javax.persistence.*;

@Entity
@Table(name = "filmtowatch")
public class FilmToWatch {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Film film;

    public FilmToWatch(){}

    public FilmToWatch(Film film) {
        this.film = film;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    @Override
    public String toString() {
        return "FilmToWatch{" +
                "id=" + id +
                ", film=" + film +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FilmToWatch that = (FilmToWatch) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return film != null ? film.equals(that.film) : that.film == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (film != null ? film.hashCode() : 0);
        return result;
    }
}
