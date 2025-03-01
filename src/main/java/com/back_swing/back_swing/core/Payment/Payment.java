package com.back_swing.back_swing.core.Payment;

import java.time.Instant;

import org.springframework.data.relational.core.mapping.Table;

import com.back_swing.back_swing.base.BaseModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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