package com.clam.gallery.services;

import com.clam.gallery.models.User;
import com.clam.gallery.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public User getUser(UUID userId) {
        Optional<User> user = userRepo.findById(userId);
        return user.orElseThrow(() -> new EntityNotFoundException(
            "The user with ID: " + userId + " was not found."
        ));
    }
}
