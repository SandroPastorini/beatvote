package com.beatvote.app.core.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter @Setter
public class Song extends PanacheEntity {
    @Column(nullable = false)
    private String name;
    @Column
    private Integer duration;
    @Column
    private LocalDate releaseDate;

    public static List<Song> getAll() {
        return listAll();
    }
}
