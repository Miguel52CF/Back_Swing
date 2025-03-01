package com.back_swing.back_swing.core.MonthlyFee;

import org.springframework.stereotype.Service;

import com.back_swing.back_swing.base.BaseRepository;
import com.back_swing.back_swing.base.BaseService;

import reactor.core.publisher.Mono;

@Service
public class MonthlyFeeService extends BaseService<MonthlyFee, Long>{
    
    public MonthlyFeeService(BaseRepository<MonthlyFee, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public Mono<Void> delete(Long id) {
        Mono<MonthlyFee> monthlyFee = findById(id)
            .map(mf -> {
                mf.setActive(false);
                return mf;
            });
            return monthlyFee.flatMap(this::save).then();
    }
}
