package com.michi.imdbservice.requests;

import com.google.gson.Gson;
import com.michi.imdbservice.model.persistance.JSONConverter;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RequestMapping("/filmInfo")
@RestController
public class FilmInfo {

    @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String filmName(@RequestParam("id") String id) {
        try {
            var json = Omdb.searchByIDDetailed(id);
            var film = JSONConverter.convertDetailedFilm(json);
            Gson gson = new Gson();
            return gson.toJson(film);
        } catch (IOException e) {
            return "{\"error\":\"odmb server connection error\"}";
        }
    }
}
