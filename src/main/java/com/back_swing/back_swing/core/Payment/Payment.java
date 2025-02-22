package com.back_swing.back_swing.core.Payment;

import java.time.Instant;

import org.springframework.data.relational.core.mapping.Table;

import com.back_swing.back_swing.base.BaseModel;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@Table("payments")
public class Payment extends BaseModel {

  private Long studentId;
  private Float amountPaid;
  private Long paymentMethodId;
  private Instant paymentDate;
  private Long guardianId;
  private Long monthlyFeeId;
  private Long paymentTypeId;
}