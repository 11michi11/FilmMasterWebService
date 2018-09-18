package com.michi.imdbservice.requests;

import com.google.gson.Gson;
import com.michi.imdbservice.model.persistance.JSONConverter;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RequestMapping("/filmName")
@RestController
public class FilmName {

    @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String filmName(@RequestParam("name") String name) {
        try {
            var json = Omdb.searchByNameShort(name);
            var films = JSONConverter.convertFilms(json);
            Gson gson = new Gson();
            return gson.toJson(films);
        } catch (IOException e) {
            return "{\"error\":\"odmb server connection error\"}";
        } catch (ArrayIndexOutOfBoundsException e){
            return "{}";
        }
    }
}
