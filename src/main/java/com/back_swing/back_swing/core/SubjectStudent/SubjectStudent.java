package com.back_swing.back_swing.core.SubjectStudent;

import org.springframework.data.relational.core.mapping.Table;

import com.back_swing.back_swing.base.BaseModel;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table("subject_students")
public class SubjectStudent extends BaseModel{

  @NotNull
  private Long subjectId;

  @NotNull
  private Long studentId;
}
