package com.michi.imdbservice.requests;

import com.michi.imdbservice.domain.User;
import com.michi.imdbservice.domain.persistance.UserRepository;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class Welcome {

    private UserRepository userRepository;

    public Welcome(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/welcome/{userId}")
    public Resource<String> welcome(@PathVariable Long userId){
        Optional<User> user = userRepository.findById(userId);
        String userName = user.isPresent() ? user.get().getName() : "Movie Maniac";

        String welcomeMsg = "Hi " + userName +"!";
//
        List<Link> links = List.of(
        );
        return new Resource<>(welcomeMsg);
    }


}
