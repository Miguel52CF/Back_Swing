package com.back_swing.back_swing.core.SubjectGrade;

import org.springframework.data.relational.core.mapping.Table;

import com.back_swing.back_swing.base.BaseModel;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table("subject_grades")
public class SubjectGrade extends BaseModel{

  @NotNull
  private Long gradeId;

  @NotNull
  private Long subjectId;
}
