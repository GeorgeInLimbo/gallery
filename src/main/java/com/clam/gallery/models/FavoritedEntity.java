package com.clam.gallery.models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Data
@Table
public class FavoritedEntity {

    @EmbeddedId
    private FavoritedEntityId id;

    private Date createdOn;

    // These annotations are meant to create a composite id from the user id and the artwork that was fav'd
    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "artworkId", insertable = false, updatable = false)
    private Artwork artwork;

    // TODO: Implement fav'ing an Artist either as a fav'd entity or in separate table completely
}
