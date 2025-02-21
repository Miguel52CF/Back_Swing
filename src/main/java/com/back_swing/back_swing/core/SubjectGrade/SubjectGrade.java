package com.back_swing.back_swing.core.SubjectGrade;

import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@Table("subject_grades")
public class SubjectGrade {

  @NotNull
  private Long gradeId;

  @NotNull
  private Long subjectId;
}
