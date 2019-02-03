package com.michi.imdbservice.model.persistance;

import com.michi.imdbservice.model.SeenFilm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeenFilmRepository extends JpaRepository<SeenFilm, Long> {
}
