package com.clam.gallery.controllers;

import com.clam.gallery.models.Artwork;
import com.clam.gallery.services.ArtworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/artworks")
public class ArtworkController {

    @Autowired
    private ArtworkService artworkService;

    @GetMapping("/{id}")
    public Artwork getWorkById(@PathVariable("id") UUID artworkId) {
        return artworkService.getWork(artworkId);
    }

    @PostMapping()
    public Artwork createWork(Map<String, String> body) {
        String title = body.get("title");
        String medium = body.get("medium");
        UUID artist = UUID.fromString(body.get("artist"));

        Artwork work = new Artwork(title, medium, artist);

        return work;
    }
}
