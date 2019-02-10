package com.michi.imdbservice.domain.persistance;

import com.michi.imdbservice.domain.Film;
import com.michi.imdbservice.domain.FilmToWatch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WatchListRepository extends JpaRepository<FilmToWatch, Long> {

    List<FilmToWatch> findAllByUser(Long user_id);
}
