package com.clam.gallery.services;

import com.clam.gallery.models.GalleryUser;
import com.clam.gallery.repositories.GalleryUserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private GalleryUserRepository userRepo;

    public GalleryUser getUser(UUID userId) {
        Optional<GalleryUser> user = userRepo.findById(userId);
        return user.orElseThrow(() -> new EntityNotFoundException(
            "The user with ID: " + userId + " was not found."
        ));
    }
}
