package com.clam.gallery.repositories;

import com.clam.gallery.models.FavoritedEntity;
import com.clam.gallery.models.FavoritedEntityId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoritedRepository extends JpaRepository<FavoritedEntity, FavoritedEntityId> {
}
