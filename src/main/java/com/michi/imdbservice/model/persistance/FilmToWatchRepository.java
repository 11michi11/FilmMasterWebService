package com.michi.imdbservice.model.persistance;

import com.michi.imdbservice.model.FilmToWatch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmToWatchRepository extends JpaRepository<FilmToWatch, Long> {
}
