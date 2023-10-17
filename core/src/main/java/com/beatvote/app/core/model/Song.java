package com.beatvote.app.core.model;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Song extends PanacheEntity {
    @Column(nullable = false)
    private String name;
    @Column
    private Integer duration;
    @Column
    private LocalDate releaseDate;
}
