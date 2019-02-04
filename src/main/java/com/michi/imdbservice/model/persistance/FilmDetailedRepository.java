package com.michi.imdbservice.model.persistance;

import com.michi.imdbservice.model.FilmDetailed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmDetailedRepository extends JpaRepository<FilmDetailed, String> {
}
