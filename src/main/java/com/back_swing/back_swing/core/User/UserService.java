package com.back_swing.back_swing.core.User;

import org.springframework.stereotype.Service;

import com.back_swing.back_swing.base.BaseService;

import reactor.core.publisher.Mono;

@Service
public class UserService extends BaseService<User, UserDTO>{

    public UserService(UserRepository userRepository){
        super(userRepository, User.class);
    }

    @Override
    public Mono<Void> delete(Long id) {
        Mono<User> user = findById(id)
            .map(u -> {
                u.setActive(false);
                return u;
            });
            return user.flatMap(this::save).then();
    }
}
