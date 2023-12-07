package com.clam.gallery.services;

import com.clam.gallery.models.Artist;
import com.clam.gallery.repositories.ArtistRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ArtistService {

    @Autowired
    private ArtistRepository artistRepo;

    public Artist getArtist(UUID artistId) {
        Optional<Artist> artist = artistRepo.findById(artistId);
        return artist.orElseThrow(() -> new EntityNotFoundException(
            "The artist with ID: " + artistId + " was not found."
        ));
    }
}
