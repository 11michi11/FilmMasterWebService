package com.michi.imdbservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "detailed_films")
@Data
@AllArgsConstructor
public class FilmDetailed extends ResourceSupport {

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

    protected FilmDetailed(){}
}

