package com.back_swing.back_swing.core.AttendanceStatus;

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
@Table("attendance_statuses")
public class AttendanceStatus extends BaseModel {
    
    @NotNull
    @NotEmpty
    private String name;
}