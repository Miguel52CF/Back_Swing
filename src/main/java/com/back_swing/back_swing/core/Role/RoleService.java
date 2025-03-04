package com.back_swing.back_swing.core.Role;

import org.springframework.stereotype.Service;

import com.back_swing.back_swing.base.BaseRepository;
import com.back_swing.back_swing.base.BaseService;

import reactor.core.publisher.Mono;

@Service
public class RoleService extends BaseService<Role, Long>{

    public RoleService(BaseRepository<Role, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public Mono<Void> delete(Long id) {
        Mono<Role> role = findById(id)
            .map(r -> {
                r.setActive(false);
                return r;
            });
            return role.flatMap(this::save).then();
    }
}
