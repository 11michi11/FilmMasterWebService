package com.michi.imdbservice.application;


import com.michi.imdbservice.domain.Film;
import com.michi.imdbservice.domain.FilmToWatch;
import com.michi.imdbservice.domain.SeenFilm;
import com.michi.imdbservice.domain.User;
import com.michi.imdbservice.domain.persistance.FilmRepository;
import com.michi.imdbservice.domain.persistance.UserRepository;
import com.michi.imdbservice.domain.persistance.WatchListRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserFilmService {


    private UserRepository userRepository;
    private FilmRepository filmRepository;
    private WatchListRepository watchListRepository;

    public UserFilmService(UserRepository userRepository, FilmRepository filmRepository) {
        this.userRepository = userRepository;
        this.filmRepository = filmRepository;
    }

    public void addFilmToUsersWatchlist(Long userId, String filmId){
        User user = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException("There is no user with id: " + userId));
        Film film = filmRepository.findByImdbID(filmId).orElseThrow(() -> new NoSuchElementException("There is no film with id: " + filmId));

        FilmToWatch filmToWatch = new FilmToWatch(film, userId);
        user.addFilmToWatchList(filmToWatch);

        userRepository.save(user);
    }

    public void addFilmToUsersSeenlist(long userId, String filmId, int grade, String review){
        User user = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException("There is no user with id: " + userId));
        Film film = filmRepository.findById(filmId).orElseThrow(() -> new NoSuchElementException("There is no film with id: " + filmId));

        SeenFilm seenFilm = new SeenFilm(film, grade, review);
        user.addFilmToSeenFilms(seenFilm);

        userRepository.save(user);
    }


    public List<FilmToWatch> getUserWatchList(Long userId) {
        return watchListRepository.findAllByUser(userId);
    }
}
