package com.michi.imdbservice.model;

import javax.persistence.*;

@Entity
@Table(name = "watchlist")
public class UsersFilm {

    @Id @GeneratedValue
    @Column(name = "id")
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userid")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "filmid")
    private Film film;

    @Column(name = "review")
    private String review;
    @Column(name = "grade")
    private int grade;
    @Column(name = "seen")
    private Boolean seen;

    public UsersFilm() {
    }

    public UsersFilm(Film film, User user, String review, int grade, boolean seen) {
        this.film = film;
        this.user = user;
        this.review = review;
        this.grade = grade;
        this.seen = seen;
    }


    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public void setSeen(boolean seen) {
        this.seen = seen;
    }

    public boolean getSeen() {
        return seen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersFilm usersFilm = (UsersFilm) o;

        if (id != usersFilm.id) return false;
        if (grade != usersFilm.grade) return false;
        if (user != null ? !user.equals(usersFilm.user) : usersFilm.user != null) return false;
        if (film != null ? !film.equals(usersFilm.film) : usersFilm.film != null) return false;
        return review != null ? review.equals(usersFilm.review) : usersFilm.review == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        //result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (film != null ? film.hashCode() : 0);
        result = 31 * result + (review != null ? review.hashCode() : 0);
        result = 31 * result + grade;
        return result;
    }

    @Override
    public String toString() {
        return "UsersFilm{" +
                "id=" + id +
                ", film=" + film +
                ", review='" + review + '\'' +
                ", grade=" + grade +
                ", seen=" + seen +
                '}';
    }
}
