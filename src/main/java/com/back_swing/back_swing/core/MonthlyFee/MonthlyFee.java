package com.back_swing.back_swing.core.MonthlyFee;

import org.springframework.data.relational.core.mapping.Table;

import com.back_swing.back_swing.base.BaseModel;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@Table("monthly_fees")
public class MonthlyFee extends BaseModel {

  private String name;
}