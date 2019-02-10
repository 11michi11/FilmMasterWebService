package com.michi.imdbservice.requests;

import com.michi.imdbservice.domain.User;
import com.michi.imdbservice.application.UserDTO;
import com.michi.imdbservice.domain.persistance.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Register {

    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public Register(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public void register(@RequestBody UserDTO userDTO) {
        User user = new User(userDTO.name, userDTO.email, passwordEncoder.encode(userDTO.password));
        userRepository.save(user);
    }

}
