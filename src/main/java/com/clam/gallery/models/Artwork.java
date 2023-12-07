package com.clam.gallery.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Artwork {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID artworkId;

    private String title;

    private String medium;

    @CreationTimestamp
    private Timestamp creationDate;

    // @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "artistId", referencedColumnName = "artistId")
    private UUID artist;

    public Artwork(String title, String medium, UUID artist) {
        this.title = title;
        this.medium = medium;
        this.artist = artist;
    }
}
