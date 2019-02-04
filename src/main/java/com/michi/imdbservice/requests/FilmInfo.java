package com.michi.imdbservice.requests;

import com.michi.imdbservice.model.Film;
import com.michi.imdbservice.model.FilmDetailed;
import com.michi.imdbservice.services.OmdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/films")
@RestController
public class FilmInfo {

    private final OmdbService omdbService;

    @Autowired
    public FilmInfo(OmdbService omdbService) {
        this.omdbService = omdbService;
    }

    @GetMapping("/")
    public List<Film> all() {
        return List.of(new Film("title1", "type1", "imbd1", "poster1", "year1"),
                new Film("title1", "type1", "imbd1", "poster1", "year1"));
    }

    @GetMapping("/{id}")
    public FilmDetailed filmInfo(@PathVariable String id) {
        return omdbService.searchByIDDetailed(id);
    }

    @GetMapping("/search/{title}")
    public List<Film> filmTitle(@PathVariable String name) {
        return omdbService.searchByNameShort(name);
    }

}
