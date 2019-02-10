package com.michi.imdbservice.requests;

import com.michi.imdbservice.application.SeenFilmDTO;
import com.michi.imdbservice.application.UserFilmService;
import com.michi.imdbservice.domain.Film;
import com.michi.imdbservice.domain.FilmToWatch;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user")
@RestController
public class ManageUserFilms {

    private UserFilmService userFilmService;

    public ManageUserFilms(UserFilmService userFilmService) {
        this.userFilmService = userFilmService;
    }

    @PostMapping("/{userId}/watch_list/{filmId}")
    public void addFilmToUserWatchList(@PathVariable Long userId, @PathVariable String filmId) {
        userFilmService.addFilmToUsersWatchlist(userId, filmId);
    }

    @GetMapping("{userId}/watch_list")
    public List<FilmToWatch> getWatchList(@PathVariable Long userId){
        return userFilmService.getUserWatchList(userId);
    }

    @PostMapping("/{userId}/seen_list/")
    public void addFilmToUserSeenList(@PathVariable long userId, @RequestBody SeenFilmDTO seenFilm){
        userFilmService.addFilmToUsersSeenlist(userId, seenFilm.filmId, seenFilm.grade, seenFilm.review);
    }

}