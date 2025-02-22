package com.back_swing.back_swing.core.AssistanceSubject;

import java.time.Instant;

import org.springframework.data.relational.core.mapping.Table;

import com.back_swing.back_swing.base.BaseModel;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@Table("assistances_subjects")
public class AssistanceSubject extends BaseModel{
    
    @NotNull
    private Long userId;
    
    @NotNull
    private Long subjectId;
    
    @NotNull
    private Long attendanceStatusId;
    
    private String comment;
    private Instant arrivalTime;
    private Instant date;
}