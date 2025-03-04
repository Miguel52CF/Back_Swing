package com.back_swing.back_swing.core.PaymentMethod;

import org.springframework.stereotype.Service;

import com.back_swing.back_swing.base.BaseRepository;
import com.back_swing.back_swing.base.BaseService;

import reactor.core.publisher.Mono;

@Service
public class PaymentMethodService extends BaseService<PaymentMethod, Long>{

    public PaymentMethodService(BaseRepository<PaymentMethod, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public Mono<Void> delete(Long id) {
        Mono<PaymentMethod> paymentMethod = findById(id)
            .map(pm -> {
                pm.setActive(false);
                return pm;
            });
            return paymentMethod.flatMap(this::save).then();
    }
    
}
