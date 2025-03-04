package com.back_swing.back_swing.core.User;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back_swing.back_swing.exceptions.ObjectNotFoundException;
import com.back_swing.back_swing.utils.ResponseController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    };

    @GetMapping
    public Mono<ResponseEntity<Map<String, Object>>> listAllUsers() {
        return userService.findAll()
                .collectList()
                .flatMap(users -> {
                    if (users != null) {
                        return Mono.just(ResponseEntity.ok(ResponseController.createApiResponse(true, "Users found", users)));
                    }
                    return Mono.error(new ObjectNotFoundException("No users found"));
                });
    };

    @GetMapping("{id}")
    public Mono<ResponseEntity<Map<String, Object>>> listUser(@PathVariable Long id) {
        return userService.findById(id)
                .flatMap(user -> Mono.just(ResponseEntity.ok(ResponseController.createApiResponse(true, "User found", user))));
    };

    @PostMapping
    public Mono<User> saveUser(@RequestBody User user) {
        return userService.save(user);
    };

    @PutMapping("{id}")
    public Mono<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.update(id, user);
    };

    @DeleteMapping("{id}")
    public Mono<ResponseEntity<Map<String, Object>>> deleteUser(@PathVariable Long id) {
        return userService.delete(id)
                .map(user -> ResponseEntity.ok(ResponseController.createApiResponse(true, "delete user", user)));
    };
}
