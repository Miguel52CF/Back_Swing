package com.back_swing.back_swing.core.Level;

import org.springframework.stereotype.Service;

import com.back_swing.back_swing.base.BaseService;

import reactor.core.publisher.Mono;

@Service
public class LevelService extends BaseService<Level, LevelDTO>{

    public LevelService(LevelRepository levelRepository){
        super(levelRepository, Level.class);
    }

    @Override
    public Mono<Void> delete(Long id) {
        Mono<Level> level = findById(id)
            .map(l -> {
                l.setActive(false);
                return l;
            });
            return level.flatMap(this::save).then();
    }
}
