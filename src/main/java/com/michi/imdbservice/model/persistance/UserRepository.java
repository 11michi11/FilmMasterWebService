package com.michi.imdbservice.model.persistance;

import com.michi.imdbservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByEmail(String email);
}
