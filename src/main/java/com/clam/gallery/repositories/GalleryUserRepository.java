package com.clam.gallery.repositories;

import com.clam.gallery.models.GalleryUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GalleryUserRepository extends JpaRepository<GalleryUser, UUID> {

}
