package com.back_swing.back_swing.base;

import org.springframework.stereotype.Service;

import lombok.Getter;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public abstract class BaseService<T, DTO> {

    private final BaseRepository<T, DTO> baseRepository;

    @Getter
    private final Class<T> modelType;

    public BaseService(BaseRepository<T, DTO> baseRepository, Class<T> modelType) {
        this.baseRepository = baseRepository;
        this.modelType = modelType;
    }

    public Mono<T> save(T t) {
        return baseRepository.save(t);
    };

    public Mono<T> findById(Long id) {
        return baseRepository.findById(id);
    };

    public Flux<T> findAll() {
        return baseRepository.findAll();
    };

    public Mono<T> update(Long id, T t) {
        return baseRepository.findById(id)
                .flatMap(model -> {
                    return baseRepository.save(t);
                });
    };

    public abstract Mono<Void> delete(Long id);
}
