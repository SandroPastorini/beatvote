package com.beatvote.app.core.base;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityExistsException;

/**
 * Una serie de métodos de utilidad para servicios.
 * Implementa servicios más comunes pero no los expone,
 * sino que tienen una visibilidad de paquete.
 * Quien lo implemente debe exponerlo para poder ser
 * usados fuera del paquete.
 */
@Service
public abstract class AbstractService<T extends BaseEntity, R extends JpaRepository<T, Long>> {
    R repository;

    Long save(T entity) {
        var p = repository.save(entity);
        return p.getId();
    }

    Long add(T entity) {
        if(repository.findById(entity.getId()).isPresent())
            throw new EntityExistsException();
        return save(entity);
    }

    void modify(T entity) {
        var p = repository.findById(entity.getId());
        if(p.isEmpty())
            throw new NoSuchElementException();
        
        repository.save(entity);
    }

    void delete(T entity) {
        var p = repository.findOne(Example.of(entity));
        if(p.isEmpty())
            throw new NoSuchElementException();
        
        repository.delete(entity);
    }

    Optional<T> get(Long id) {
        return repository.findById(id);
    }

    List<T> findAll() {
        return repository.findAll();
    }

}
