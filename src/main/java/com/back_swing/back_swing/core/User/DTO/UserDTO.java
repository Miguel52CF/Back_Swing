package com.back_swing.back_swing.core.User.DTO;

public record UserDTO(
    Long id,
    String name,
    Long roleId,
    Long gradeId,
    Long scheduleTypeId) {
}
