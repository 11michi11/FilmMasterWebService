package com.michi.imdbservice.domain;

import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "users")
@ToString
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @Getter
    private String name;

    @Column(name = "email")
    @Getter
    private String email;

    @Column(name = "pwd")
    @Getter
    private String pwd;

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "user_id")
    private List<SeenFilm> seenFilms;

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "user_id")
    private List<FilmToWatch> watchList;

    public User(String name, String email, String pwd, List<SeenFilm> seenFilms, List<FilmToWatch> watchList) {
        this.name = name;
        this.email = email;
        this.pwd = pwd;
        this.seenFilms = seenFilms;
        this.watchList = watchList;
    }

    public User(String name, String email, String pwd) {
        this.name = name;
        this.email = email;
        this.pwd = pwd;
        this.seenFilms = new LinkedList<>();
        this.watchList = new LinkedList<>();
    }

    public void addFilmToWatchList(FilmToWatch filmToWatch) {
        watchList.add(filmToWatch);
    }

    public void addFilmToSeenFilms(SeenFilm seenFilm){
        seenFilms.add(seenFilm);
    }

}

