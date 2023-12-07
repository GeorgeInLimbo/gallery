package com.clam.gallery.services;

import com.clam.gallery.models.Artwork;
import com.clam.gallery.repositories.ArtworkRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ArtworkService {

    @Autowired
    private ArtworkRepository artworkRepo;

    public Artwork getWork(UUID artworkId) {
        Optional<Artwork> artwork = artworkRepo.findById(artworkId);
        return artwork.orElseThrow(() -> new EntityNotFoundException(
            "The artwork with ID: " + artworkId + " was not found."
        ));
    }
}
