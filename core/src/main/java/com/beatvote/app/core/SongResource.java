package com.beatvote.app.core;

import com.beatvote.app.core.model.Song;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.util.List;

@Path("/songs")
public class SongResource {
    @GET
    public List<Song> getSong() {
        return Song.getAll();
    }
}
