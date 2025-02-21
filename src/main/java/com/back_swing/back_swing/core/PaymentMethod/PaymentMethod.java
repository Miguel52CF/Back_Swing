package com.back_swing.back_swing.core.PaymentMethod;

import org.springframework.data.relational.core.mapping.Table;

import com.back_swing.back_swing.base.BaseModel;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@Table("payment_methods")
public class PaymentMethod extends BaseModel {

  @NotNull
  @NotEmpty
  private String name;
}
