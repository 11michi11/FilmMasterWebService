package com.michi.imdbservice.model;

import javax.persistence.*;

@Entity
@Table(name = "seenfilm")
public class SeenFilm {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    private Film film;

    @Column
    private int grade;

    @Column
    private String review;

    public SeenFilm(){}

    public SeenFilm(Film film, int grade, String review) {
        this.film = film;
        this.grade = grade;
        this.review = review;
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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return "SeenFilm{" +
                "id=" + id +
                ", film=" + film +
                ", grade=" + grade +
                ", review='" + review + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SeenFilm seenFilm = (SeenFilm) o;

        if (grade != seenFilm.grade) return false;
        if (id != null ? !id.equals(seenFilm.id) : seenFilm.id != null) return false;
        if (film != null ? !film.equals(seenFilm.film) : seenFilm.film != null) return false;
        return review != null ? review.equals(seenFilm.review) : seenFilm.review == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (film != null ? film.hashCode() : 0);
        result = 31 * result + grade;
        result = 31 * result + (review != null ? review.hashCode() : 0);
        return result;
    }
}
