package com.michi.imdbservice.application;

import lombok.Data;

@Data
public class SeenFilmDTO {
    public String filmId;
    public int grade;
    public String review;
}
