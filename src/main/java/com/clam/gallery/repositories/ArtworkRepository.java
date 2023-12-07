package com.clam.gallery.repositories;

import com.clam.gallery.models.Artwork;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ArtworkRepository extends JpaRepository<Artwork, UUID> {

}
