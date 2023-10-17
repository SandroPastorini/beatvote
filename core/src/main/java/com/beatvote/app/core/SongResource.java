package com.beatvote.app.core;

import java.net.URI;
import java.util.List;

import com.beatvote.app.core.model.Song;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/songs")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class SongResource {
    @GET
    public Uni<List<Song>> getAllSongs() {
        return Song.listAll();
    }

    @PUT
    public Uni<Response> addSong(Song song) {
        Uni<Song> result = song.persist();
        return result
                .onItem()
                    .transform(inserted -> Response.created(URI.create("/songs/" + inserted.id)).build());
    }

    @GET
    @Path("/find-by-name/{name}")
    public Uni<List<Song>> findSongByName(@PathParam("name") String name) {
        return Song.find("name", name).list();
    }
}
