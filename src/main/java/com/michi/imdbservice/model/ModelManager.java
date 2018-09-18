package com.michi.imdbservice.model;

import java.util.List;
import java.util.NoSuchElementException;

public interface ModelManager {

    public void addUser(User user);

    void addFilmToUsersList(UsersFilm film, User user);

    public List<User> getUsers();

    public void addFilm(Film film);

    public List<Film> getFilms();

    public User getUserByID(int id) throws NoSuchElementException;

    public Film getFilmByID(String id)  throws NoSuchElementException;

}
