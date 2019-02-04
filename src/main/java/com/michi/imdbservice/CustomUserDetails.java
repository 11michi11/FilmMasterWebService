package com.michi.imdbservice;

import com.michi.imdbservice.model.User;
import com.michi.imdbservice.model.persistance.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
