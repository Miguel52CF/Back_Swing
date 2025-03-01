package com.back_swing.back_swing.core.Grade;

import org.springframework.stereotype.Service;

import com.back_swing.back_swing.base.BaseRepository;
import com.back_swing.back_swing.base.BaseService;

import reactor.core.publisher.Mono;

@Service
public class GradeService extends BaseService<Grade, Long>{

    public GradeService(BaseRepository<Grade, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public Mono<Void> delete(Long id) {
        Mono<Grade> grade = findById(id)
            .map(gr -> {
                gr.setActive(false);
                return gr;
            });
            return grade.flatMap(this::save).then();
    }
    
}
