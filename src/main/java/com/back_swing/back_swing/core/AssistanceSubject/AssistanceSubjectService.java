package com.back_swing.back_swing.core.AssistanceSubject;

import org.springframework.stereotype.Service;

import com.back_swing.back_swing.base.BaseService;

import reactor.core.publisher.Mono;

@Service
public class AssistanceSubjectService extends BaseService<AssistanceSubject, AssistanceSubjectDTO>{

    public AssistanceSubjectService(AssistanceSubjectRepository assistanceSubjectRepository) {
        super(assistanceSubjectRepository, AssistanceSubject.class);
    }

    @Override
    public Mono<Void> delete(Long id) {
        Mono<AssistanceSubject> assistanceSubject = findById(id)
            .map(as -> {
                as.setActive(false);
                return as;
            });
            return assistanceSubject.flatMap(this::save).then();
    }
    
}
