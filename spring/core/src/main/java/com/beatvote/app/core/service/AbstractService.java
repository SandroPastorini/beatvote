package com.beatvote.app.core.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beatvote.app.core.base.BaseEntity;

public class AbstractService<T extends BaseEntity, R extends JpaRepository<T, Long>> {
    R repository;

    public Long save(T entity) {
        var p = repository.save(entity);
        return p.getId();
    }
}
