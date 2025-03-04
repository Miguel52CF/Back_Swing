package com.back_swing.back_swing.core.User;

import org.springframework.stereotype.Service;

import com.back_swing.back_swing.base.BaseRepository;
import com.back_swing.back_swing.base.BaseService;
import com.back_swing.back_swing.exceptions.ObjectNotFoundException;

import reactor.core.publisher.Mono;

@Service
public class UserService extends BaseService<User, Long>{

    public UserService(BaseRepository<User, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public Mono<Void> delete(Long id) {
        return findById(id)
            .switchIfEmpty(Mono.error(new ObjectNotFoundException("User not found")))
            .flatMap(user -> {
                user.setActive(false);
                return save(user);
            }).then();
    }
}
