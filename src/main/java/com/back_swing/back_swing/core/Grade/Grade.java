package com.back_swing.back_swing.core.Grade;

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
@Table("grades")
public class Grade extends BaseModel {

  @NotNull
  @NotEmpty
  private String name;
}
