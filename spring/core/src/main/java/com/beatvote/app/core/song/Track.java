package com.beatvote.app.core.song;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

@Entity
@Getter @Setter
public class Track {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    
    private String spotifyId;

    private LocalDate releaseDate;

    private ReleaseDatePrecision releaseDatePrecission;
}
