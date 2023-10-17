package com.beatvote.app.core;

import com.beatvote.app.core.model.Song;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import java.time.LocalDate;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

@QuarkusTest
class SongResourceTest {
    @Test
    void givenSong_whenPutting_shouldCreate(){
        Song song = new Song("Otra Canción", 128, LocalDate.now());
        given()
                .contentType(ContentType.JSON)
                .body(song)
         .when().put("songs")
         .then().statusCode(201)
                .body(is(4));
    }

}
