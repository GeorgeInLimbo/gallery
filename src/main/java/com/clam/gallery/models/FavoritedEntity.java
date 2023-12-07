package com.clam.gallery.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Data
@Table
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FavoritedEntity {

    @EmbeddedId
    private FavoritedEntityId id;

    @CreationTimestamp
    private Timestamp createdOn;

    // These annotations are meant to create a composite id from the user id and the artwork that was fav'd
    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    private GalleryUser user;

    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "artworkId", insertable = false, updatable = false)
    private Artwork artwork;

    // TODO: Implement fav'ing an Artist either as a fav'd entity or in separate table completely


    public FavoritedEntity(GalleryUser user, Artwork artwork) {
        this.user = user;
        this.artwork = artwork;
    }
}
