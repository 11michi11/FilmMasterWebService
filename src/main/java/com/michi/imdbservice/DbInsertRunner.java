package com.michi.imdbservice;

import com.michi.imdbservice.domain.Film;
import com.michi.imdbservice.domain.FilmToWatch;
import com.michi.imdbservice.domain.SeenFilm;
import com.michi.imdbservice.domain.User;
import com.michi.imdbservice.domain.persistance.FilmRepository;
import com.michi.imdbservice.domain.persistance.UserRepository;
import com.michi.imdbservice.domain.persistance.WatchListRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbInsertRunner implements CommandLineRunner {


    private FilmRepository filmRepository;
    private UserRepository userRepository;
    private WatchListRepository watchListRepository;


    public DbInsertRunner(FilmRepository filmRepository, UserRepository userRepository, WatchListRepository watchListRepository) {
        this.filmRepository = filmRepository;
        this.userRepository = userRepository;
        this.watchListRepository = watchListRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(watchListRepository.findAllByUser(1L));
        //Populate DB
        if(filmRepository.count() == 0){
//            Film film = new Film("Test", "test", "testId", "testUrl", "2000");
//            Film filmSeen = new Film("TestSeen", "testSeen", "testIdSeen", "testUrlSeen", "2001");
//
//           FilmToWatch filmToWatch = new FilmToWatch(film, user);
//            SeenFilm seenFilm = new SeenFilm(filmSeen, 5, "Awesome");
//
//            User user = new User("JohnnyTest", "testEmail", "pwd", List.of(seenFilm),List.of(filmToWatch));
//
//
//            filmRepository.saveAll(List.of(film, filmSeen));
//            userRepository.save(user);
//
//
//            System.out.println("Number of films: " + filmRepository.count());
        }
    }
}
