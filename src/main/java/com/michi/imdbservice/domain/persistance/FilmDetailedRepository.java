package com.michi.imdbservice.domain.persistance;

import com.michi.imdbservice.domain.FilmDetailed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmDetailedRepository extends JpaRepository<FilmDetailed, String> {
}
