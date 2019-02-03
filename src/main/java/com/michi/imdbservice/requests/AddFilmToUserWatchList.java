package com.michi.imdbservice.requests;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/addFilmToUserWatchList")
@RestController
public class AddFilmToUserWatchList {

    @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String addFilmToUser(@RequestParam("userId") int userId, @RequestParam("filmId") String filmId) {

        String response = "";//Controller.addFilmToUsersWatchList(filmId, userId);
        return "{\"status\":\"" + response + "\"}";
    }
}