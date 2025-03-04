package com.back_swing.back_swing.core.Subject;

import org.springframework.stereotype.Service;

import com.back_swing.back_swing.base.BaseRepository;
import com.back_swing.back_swing.base.BaseService;

import reactor.core.publisher.Mono;

@Service
public class SubjectService extends BaseService<Subject, Long>{

    public SubjectService(BaseRepository<Subject, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public Mono<Void> delete(Long id) {
        Mono<Subject> subject = findById(id)
            .map(s -> {
                s.setActive(false);
                return s;
            });
            return subject.flatMap(this::save).then();
    }
}
