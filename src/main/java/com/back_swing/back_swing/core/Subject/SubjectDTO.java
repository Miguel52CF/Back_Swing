package com.back_swing.back_swing.core.Subject;

import java.time.Instant;

public record SubjectDTO(
    Long id,
    String name,
    Long teacherId,
    Long levelId,
    Integer section,
    Long academicPeriodId,
    Integer daysOfWeek,
    Instant startTime,
    Instant endTime,
    String classroom
) {
}
