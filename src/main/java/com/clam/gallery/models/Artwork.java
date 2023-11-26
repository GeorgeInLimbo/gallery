package com.clam.gallery.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.sql.Date;
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
    private UUID artworkId;

    private String title;

    private String medium;

    private Date creationDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "artistId", referencedColumnName = "artistId")
    private Artist artist;

}
