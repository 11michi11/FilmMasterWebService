package com.michi.imdbservice.security;

import com.michi.imdbservice.domain.User;
import com.michi.imdbservice.domain.persistance.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetails implements UserDetailsService {

    @Autowired
    private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User byEmail = repo.findByEmail(email);
        return new org.springframework.security.core.userdetails.User(
                byEmail.getEmail(),byEmail.getPwd(),true, true, true, true,
                AuthorityUtils.createAuthorityList("ROLE_TRUSTED_CLIENT")
        );

    }

}
