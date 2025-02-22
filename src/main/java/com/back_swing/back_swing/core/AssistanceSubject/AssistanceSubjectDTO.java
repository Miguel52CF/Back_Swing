package com.back_swing.back_swing.core.AssistanceSubject;

import java.time.Instant;

public record AssistanceSubjectDTO(
    Long id,
    Long userId, Long subjectId, 
    Long attendanceStatusId, 
    String comment, 
    Instant arrivalTime, 
    Instant date) {
}
