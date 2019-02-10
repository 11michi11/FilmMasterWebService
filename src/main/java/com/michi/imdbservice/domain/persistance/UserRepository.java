package com.michi.imdbservice.domain.persistance;

import com.michi.imdbservice.domain.Film;
import com.michi.imdbservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByEmail(String email);
}
