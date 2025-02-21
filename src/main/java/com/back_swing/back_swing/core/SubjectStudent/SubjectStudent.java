package com.back_swing.back_swing.core.SubjectStudent;

import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@Table("subject_students")
public class SubjectStudent {

  @NotNull
  private Long subjectId;

  @NotNull
  private Long studentId;
}
