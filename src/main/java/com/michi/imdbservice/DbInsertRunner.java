package com.michi.imdbservice;

import com.michi.imdbservice.model.Film;
import com.michi.imdbservice.model.FilmToWatch;
import com.michi.imdbservice.model.SeenFilm;
import com.michi.imdbservice.model.User;
import com.michi.imdbservice.model.persistance.FilmRepository;
import com.michi.imdbservice.model.persistance.FilmToWatchRepository;
import com.michi.imdbservice.model.persistance.SeenFilmRepository;
import com.michi.imdbservice.model.persistance.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbInsertRunner implements CommandLineRunner {


    private FilmRepository filmRepository;
    private UserRepository userRepository;
    private SeenFilmRepository seenFilmRepository;
    private FilmToWatchRepository filmToWatchRepository;


    public DbInsertRunner(FilmRepository filmRepository, UserRepository userRepository, SeenFilmRepository seenFilmRepository, FilmToWatchRepository filmToWatchRepository) {
        this.filmRepository = filmRepository;
        this.userRepository = userRepository;
        this.seenFilmRepository = seenFilmRepository;
        this.filmToWatchRepository = filmToWatchRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        //Populate DB
        if(filmRepository.count() == 0){
            Film film = new Film("Test", "test", "testId", "testUrl", "2000");
            Film filmSeen = new Film("TestSeen", "testSeen", "testIdSeen", "testUrlSeen", "2001");

            FilmToWatch filmToWatch = new FilmToWatch(film);
            SeenFilm seenFilm = new SeenFilm(filmSeen, 5, "Awesome");

            User user = new User("JohnnyTest", "testEmail", "pwd", List.of(seenFilm),List.of(filmToWatch));


            filmRepository.saveAll(List.of(film, filmSeen));
            //  filmToWatchRepository.save(filmToWatch);
            //  seenFilmRepository.save(seenFilm);
            userRepository.save(user);


            System.out.println("Number of films: " + filmRepository.count());
        }
    }
}
