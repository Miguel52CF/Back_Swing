package com.back_swing.back_swing.core.AttendanceStatus;

import org.springframework.stereotype.Service;

import com.back_swing.back_swing.base.BaseRepository;
import com.back_swing.back_swing.base.BaseService;

import reactor.core.publisher.Mono;

@Service
public class AttendanceStatusService extends BaseService<AttendanceStatus, Long>{

    public AttendanceStatusService(BaseRepository<AttendanceStatus, Long> baseRepository) {
        super(baseRepository);
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
