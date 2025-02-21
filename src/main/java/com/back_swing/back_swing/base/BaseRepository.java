package com.back_swing.back_swing.base;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface BaseRepository<T, DTO> extends ReactiveCrudRepository<T, Long> {

}
