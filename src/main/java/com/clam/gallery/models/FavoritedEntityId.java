package com.clam.gallery.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@Embeddable
@IdClass(User.class)
public class FavoritedEntityId implements Serializable {
    @Column(name = "id", nullable = false)
    private UUID userId;

    @Column(name = "artworkId", nullable = false)
    private UUID artworkId;
}
