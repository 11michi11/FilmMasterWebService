package com.michi.imdbservice.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "pwd")
    private String pwd;

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "user_id")
    private List<SeenFilm> seenFilms;

    @OneToMany( cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "user_id")
    private List<FilmToWatch> watchList;

    public User() {}

    public User(String name, String email, String pwd, List<SeenFilm> seenFilms, List<FilmToWatch> watchList) {
        this.name = name;
        this.email = email;
        this.pwd = pwd;
        this.seenFilms = seenFilms;
        this.watchList = watchList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public List<SeenFilm> getSeenFilms() {
        return seenFilms;
    }

    public void setSeenFilms(List<SeenFilm> seenFilms) {
        this.seenFilms = seenFilms;
    }

    public List<FilmToWatch> getWatchList() {
        return watchList;
    }

    public void setWatchList(List<FilmToWatch> watchList) {
        this.watchList = watchList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", pwd='" + pwd + '\'' +
                ", seenFilms=" + seenFilms +
                ", watchList=" + watchList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (pwd != null ? !pwd.equals(user.pwd) : user.pwd != null) return false;
        if (seenFilms != null ? !seenFilms.equals(user.seenFilms) : user.seenFilms != null) return false;
        return watchList != null ? watchList.equals(user.watchList) : user.watchList == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (pwd != null ? pwd.hashCode() : 0);
        result = 31 * result + (seenFilms != null ? seenFilms.hashCode() : 0);
        result = 31 * result + (watchList != null ? watchList.hashCode() : 0);
        return result;
    }
}
