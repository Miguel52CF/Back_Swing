package com.back_swing.back_swing.core.User;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back_swing.back_swing.exceptions.ObjectNotFoundException;
import com.back_swing.back_swing.utils.ResponseController;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    
    @GetMapping
    public Flux<Map<String, Object>> listAllUsers() {
        return userService.findAll()
            .switchIfEmpty(Flux.error(new ObjectNotFoundException("No users found")))
            .map(user -> ResponseController.createApiResponse(true, "User fund", user));
    }

    @GetMapping("{id}")
    public Mono<User> listUser(@PathVariable Long id) {
        return userService.findById(id);
    };

    @PostMapping
    public Mono<User> saveUser(@RequestBody User user) {
        return userService.save(user);
    };
}
