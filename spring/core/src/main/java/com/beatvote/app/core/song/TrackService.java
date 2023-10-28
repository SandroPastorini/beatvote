package com.beatvote.app.core.song;

import org.springframework.stereotype.Service;

@Service
public class TrackService {
    TrackRepository repository;

    TrackService(TrackRepository repository) {
        this.repository = repository;
    }
}
