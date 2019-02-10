package com.michi.imdbservice.domain.persistance;

import com.michi.imdbservice.domain.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FilmRepository extends JpaRepository<Film, String> {

    Optional<Film> findByImdbID(String imbdId);
}
