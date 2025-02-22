package com.back_swing.back_swing.core.Payment;

import java.time.Instant;

public record PaymentDTO(
    Long id,
    Long studentId,
    Float amountPaid,
    Long paymentMethodId,
    Instant paymentDate,
    Long guardianId,
    Long monthlyFeeId,
    Long paymentTypeId) {
}