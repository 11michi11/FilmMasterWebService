package com.michi.imdbservice.requests;

import com.michi.imdbservice.Controller;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RequestMapping("/addFilm")
@RestController
public class AddFilmToUser {

    @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String addFilmToUser(@RequestParam("userId") int userId, @RequestParam("filmId") String filmId,
                                @RequestParam("review") String review,@RequestParam("grade") int grade, @RequestParam("seen") boolean seen) {

        String response = Controller.addFilmToUsersList(filmId, userId, review, grade, seen);
        return "{\"status\":\"" + response + "\"}";
    }
}