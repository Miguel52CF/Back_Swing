package com.back_swing.back_swing.base;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public abstract class BaseService<T, ID> {

    private final BaseRepository<T, ID> baseRepository;

    public BaseService(BaseRepository<T, ID> baseRepository) {
        this.baseRepository = baseRepository;
    };

    public Mono<T> save(T t) {
        return baseRepository.save(t);
    };

    public Mono<T> findById(ID id) {
        return baseRepository.findById(id);
    };

    public Flux<T> findAll() {
        return baseRepository.findAll();
    };

    public Mono<T> update(ID id, T t) {
        return baseRepository.findById(id)
                .flatMap(model -> {
                    return baseRepository.save(t);
                });
    };

    public abstract Mono<Void> delete(ID id);
}
