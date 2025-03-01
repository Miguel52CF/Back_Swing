package com.back_swing.back_swing.core.User;

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
@Table("users")
public class User extends BaseModel {
    
    @NotNull
    @NotEmpty
    private String name;
    
    private Long roleId;
    private Long gradeId;
    private Long scheduleTypeId;
}
