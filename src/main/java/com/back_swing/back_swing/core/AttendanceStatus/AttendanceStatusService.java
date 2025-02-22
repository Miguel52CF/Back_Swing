package com.back_swing.back_swing.core.AttendanceStatus;

import org.springframework.stereotype.Service;

import com.back_swing.back_swing.base.BaseService;

import reactor.core.publisher.Mono;

@Service
public class AttendanceStatusService extends BaseService<AttendanceStatus, AttendanceStatusDTO>{

    public AttendanceStatusService(AttendanceStatusRepository attendanceStatusRepository) {
        super(attendanceStatusRepository, AttendanceStatus.class);
    }

    @Override
    public Mono<Void> delete(Long id) {
        Mono<AttendanceStatus> attendanceStatus = findById(id)
            .map(at -> {
                at.setActive(false);
                return at;
            });
            return attendanceStatus.flatMap(this::save).then();
    }
    
}
