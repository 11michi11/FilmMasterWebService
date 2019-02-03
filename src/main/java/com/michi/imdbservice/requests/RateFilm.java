package com.michi.imdbservice.requests;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/rateFilm")
@RestController
public class RateFilm {

    @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String rateFilm(@RequestParam("userId") int userId, @RequestParam("filmId") String filmId,
                           @RequestParam("review") String review, @RequestParam("grade") int grade){

        String response ="";// Controller.rateUserFilm(filmId, userId, review, grade);
        return "{\"status\":\"" + response + "\"}";
    }
}
