package com.back_swing.back_swing.core.PaymentType;

import org.springframework.stereotype.Service;

import com.back_swing.back_swing.base.BaseService;

import reactor.core.publisher.Mono;

@Service
public class PaymentTypeService extends BaseService<PaymentType, PaymentTypeDTO>{

    public PaymentTypeService(PaymentTypeRepository paymentTypeRepository){
        super(paymentTypeRepository, PaymentType.class);
    }

    @Override
    public Mono<Void> delete(Long id) {
        Mono<PaymentType> paymentType = findById(id)
            .map(pm -> {
                pm.setActive(false);
                return pm;
            });
            return paymentType.flatMap(this::save).then();
    }
}
