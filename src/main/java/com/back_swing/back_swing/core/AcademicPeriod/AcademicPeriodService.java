package com.back_swing.back_swing.core.AcademicPeriod;

import org.springframework.stereotype.Service;

import com.back_swing.back_swing.base.BaseRepository;
import com.back_swing.back_swing.base.BaseService;

import reactor.core.publisher.Mono;

@Service
public class AcademicPeriodService extends BaseService<AcademicPeriod, Long>{

    public AcademicPeriodService(BaseRepository<AcademicPeriod, Long> baseRepository) {
            super(baseRepository);
    }
    
    @Override
    public Mono<Void> delete(Long id) {
        Mono<AcademicPeriod> academicPeriod = findById(id)
            .map(ap -> {
                ap.setActive(false);
                return ap;
            });
            return academicPeriod.flatMap(this::save).then();
    }
}
