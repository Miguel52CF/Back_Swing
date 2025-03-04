package com.back_swing.back_swing.core.Payment;

import org.springframework.stereotype.Service;

import com.back_swing.back_swing.base.BaseRepository;
import com.back_swing.back_swing.base.BaseService;

import reactor.core.publisher.Mono;

@Service
public class PaymentService extends BaseService<Payment, Long>{

    public PaymentService(BaseRepository<Payment, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public Mono<Void> delete(Long id) {
        Mono<Payment> payment = findById(id)
            .map(p -> {
                p.setActive(false);
                return p;
            });
            return payment.flatMap(this::save).then();
    }
}
