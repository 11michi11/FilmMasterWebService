package com.michi.imdbservice.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "filmtowatch")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@EqualsAndHashCode
@Getter
public class FilmToWatch {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Film film;

    @Column(name = "user_id")
    private Long user;

    public FilmToWatch(Film film, Long user) {
        this.film = film;
        this.user = user;
    }


}
