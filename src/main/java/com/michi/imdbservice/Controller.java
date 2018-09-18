package com.michi.imdbservice;

import com.michi.imdbservice.model.*;

import java.util.NoSuchElementException;

public class Controller {

    private static ModelManager model = new ImdbModelManager();

    private Controller(){}

    public static String addFilmToUsersList(String filmId, int userId, String review, int grade, boolean seen) {
        User user;
        Film film;

        try{
            user = model.getUserByID(userId);
        }catch(NoSuchElementException e){
            return "FAIL: User not found";
        }
        try{
            film = model.getFilmByID(filmId);
        }catch(NoSuchElementException e){
            return "FAIL: Film not found";
        }

        UsersFilm usersFilm = new UsersFilm(film, user, review, grade, seen);
        model.addFilmToUsersList(usersFilm, user);

        return "SUCCESS";
    }


}
