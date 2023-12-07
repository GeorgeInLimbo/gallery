package com.clam.gallery.services;

import com.clam.gallery.models.FavoritedEntity;
import com.clam.gallery.models.FavoritedEntityId;
import com.clam.gallery.repositories.FavoritedRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FavoritedEntityService {

    @Autowired
    private FavoritedRepository faveRepo;

    public FavoritedEntity getFave(FavoritedEntityId faveId) {
        Optional<FavoritedEntity> fave = faveRepo.findById(faveId);
        return fave.orElseThrow(() -> new EntityNotFoundException(
            "The favorited item with ID: " + faveId + " was not found."
        ));
    }
}
