package com.back_swing.back_swing.core.QualificationSubject;

import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table("qualification_subjects")
public class QualificationSubject {

  private Integer qualification;

  @NotNull
  private Long subjectId;

  @NotNull
  private Long userId;
}
