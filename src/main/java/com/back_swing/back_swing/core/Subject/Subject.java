package com.back_swing.back_swing.core.Subject;

import java.time.Instant;

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
@Table("subjects")
public class Subject extends BaseModel {

  @NotNull
  @NotEmpty
  private String name;

  private Long teacherId;
  private Long levelId;
  private Integer section;
  private Long academicPeriodId;
  private Integer daysOfWeek;
  private Instant startTime;
  private Instant endTime;
  private String classroom;
}
