package com.michi.imdbservice.model;

import com.michi.imdbservice.model.persistance.HibernateAdapter;
import com.michi.imdbservice.model.persistance.Persistance;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class ImdbModelManager implements ModelManager {

    private static ImdbModelManager instance;
    private Persistance db = HibernateAdapter.getInstance();
    private List<User> users = new LinkedList<>();
    private List<Film> films = new LinkedList<>();

    public ImdbModelManager() {
        users = db.getAllUsers();
        films = db.getAllFilms();
        System.out.println("State of model:\n" + "Users: " + users + "\nFilms: " + films);
    }

    @Override
    public void addUser(User user) {
        users.add(user);
        db.addUser(user);
    }

    @Override
    public void addFilmToUsersList(UsersFilm film, User user) {
        user.addFilm(film);
        db.updateUser(user);
    }

    @Override
    public List<User> getUsers() {
        return db.getAllUsers();
    }

    @Override
    public void addFilm(Film film) {
        films.add(film);
        db.addFilm(film);
        showDB();
    }

    @Override
    public List<Film> getFilms() {
        return db.getAllFilms();
    }

    @Override
    public User getUserByID(int id) throws NoSuchElementException {
        return users.stream().filter(user -> user.getID() == id).findAny().orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Film getFilmByID(String id) throws NoSuchElementException {
        return films.stream().filter(film -> film.getImdbID().equals(id)).findAny().orElseThrow(NoSuchElementException::new);
    }


    private void showDB(){
        System.out.println("State of model:\n" + "Users: " + db.getAllUsers() + "\nFilms: " + db.getAllFilms());
    }


}
