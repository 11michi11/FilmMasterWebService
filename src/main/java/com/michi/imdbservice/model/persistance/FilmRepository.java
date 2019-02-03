package com.michi.imdbservice.model.persistance;

import com.michi.imdbservice.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {
}
