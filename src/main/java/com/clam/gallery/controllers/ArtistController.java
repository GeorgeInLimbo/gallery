package com.clam.gallery.controllers;

import com.clam.gallery.models.Artist;
import com.clam.gallery.services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/artists")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @GetMapping("/{id}")
    public Artist getArtistById(@PathVariable("id") UUID artistId) {
        return artistService.getArtist(artistId);
    }

    @PostMapping
    public Artist createArtist(Map<String, String> body) {
        UUID user = UUID.fromString(body.get("user"));
        String description = body.get("description");

        Artist artist = new Artist(user, description);

        return artist;
    }

}
