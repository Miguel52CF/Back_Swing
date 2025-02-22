package com.back_swing.back_swing.core.Payment;

import org.springframework.stereotype.Service;

import com.back_swing.back_swing.base.BaseService;

import reactor.core.publisher.Mono;

@Service
public class PaymentService extends BaseService<Payment, PaymentDTO>{

    public PaymentService(PaymentRepository paymentRepository){
        super(paymentRepository, Payment.class);
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
