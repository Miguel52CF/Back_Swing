package com.back_swing.back_swing.core.ScheduleUser;

import java.time.Instant;

import org.springframework.data.relational.core.mapping.Table;

import com.back_swing.back_swing.base.BaseModel;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table("schedules_users")
public class ScheduleUser extends BaseModel {
    
    @NotNull
    private Long userId;
    
    @NotNull
    @NotEmpty
    private String shift;
    
    private Integer day;
    private Instant startTime;
    private Instant endTime;
}