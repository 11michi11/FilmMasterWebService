package com.michi.imdbservice.requests;

import com.google.gson.Gson;
import com.michi.imdbservice.model.Film;
import com.michi.imdbservice.model.persistance.JSONConverter;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RequestMapping("/filmInfo")
@RestController
public class FilmInfo {

    @GetMapping("/films")
    public List<Film> all() {
        return List.of(new Film("title1", "type1", "imbd1", "poster1", "year1"),
                new Film("title1", "type1", "imbd1", "poster1", "year1"));
    }

    @GetMapping("/films/{id}")
    public String filmName(@PathVariable String id) {
        try {
            var json = OmdbService.searchByIDDetailed(id);
            var film = JSONConverter.convertDetailedFilm(json);
            Gson gson = new Gson();
            return gson.toJson(film);
        } catch (IOException e) {
            return "{\"error\":\"odmb server connection error\"}";
        }
    }
}
