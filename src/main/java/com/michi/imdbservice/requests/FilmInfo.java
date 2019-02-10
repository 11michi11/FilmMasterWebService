package com.michi.imdbservice.requests;

import com.michi.imdbservice.domain.Film;
import com.michi.imdbservice.domain.FilmDetailed;
import com.michi.imdbservice.services.OmdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

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

    @GetMapping("/{filmId}/{userId}")
    public FilmDetailed filmInfo(@PathVariable String filmId, @PathVariable(required = false) long userId) throws NoSuchMethodException {
        System.out.println(userId);
        FilmDetailed filmDetailed = omdbService.searchByIDDetailed(filmId);
        filmDetailed.add();
        List<Link> links = List.of(
                linkTo(FilmInfo.class).slash(filmId).withSelfRel(),
                linkTo(ManageUserFilms.class, ManageUserFilms.class
                        .getMethod("addFilmToUserWatchList", Long.class, String.class), userId, filmId)
                        .withRel("addFilmToWatchList"));

        filmDetailed.add(links);
        return filmDetailed;
    }

    @GetMapping("{userId}/search/{title}")
    public List<Film> filmTitle(@PathVariable String title, @PathVariable Long userId) throws NoSuchMethodException {
        List<Film> films = omdbService.searchByNameShort(title);

        for (Film film : films) {
            Link selfLink = linkTo(methodOn(FilmInfo.class).filmInfo(film.getImdbID(), userId)).withSelfRel();
            film.add(selfLink);
        }

        return films;
    }

}
