package com.back_swing.back_swing.base;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

@NoRepositoryBean
public interface BaseRepository<T, ID> extends ReactiveCrudRepository<T, ID> {
}
