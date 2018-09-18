package com.michi.imdbservice.model.persistance;

import com.michi.imdbservice.model.Film;
import com.michi.imdbservice.model.User;

import java.util.List;

public interface Persistance {

    List<User> getAllUsers();

    void addUser(User user);

    void updateUser(User user);

    List<Film> getAllFilms();

    void addFilm(Film film);
}
