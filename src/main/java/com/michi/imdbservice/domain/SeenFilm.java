package com.michi.imdbservice.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "seenfilm")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@EqualsAndHashCode
@Getter
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

    public SeenFilm(Film film, int grade, String review) {
        this.film = film;
        this.grade = grade;
        this.review = review;
    }


}
