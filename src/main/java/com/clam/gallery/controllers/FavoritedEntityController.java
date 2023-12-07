package com.clam.gallery.controllers;

import com.clam.gallery.models.Artwork;
import com.clam.gallery.models.FavoritedEntity;
import com.clam.gallery.models.FavoritedEntityId;
import com.clam.gallery.models.GalleryUser;
import com.clam.gallery.services.ArtworkService;
import com.clam.gallery.services.FavoritedEntityService;
import com.clam.gallery.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/favorites")
public class FavoritedEntityController {

    @Autowired
    private FavoritedEntityService faveService;

    @Autowired
    private UserService userService;

    @Autowired
    private ArtworkService artworkService;

    @GetMapping("{id}")
    public FavoritedEntity getFaveById(@PathVariable("id") FavoritedEntityId faveId) {
        return faveService.getFave(faveId);
    }

    @PostMapping
    public FavoritedEntity createFave(Map<String, UUID> body) {
        GalleryUser user = userService.getUser(body.get("user"));
        Artwork work = artworkService.getWork(body.get("artwork"));

        FavoritedEntity fave = new FavoritedEntity(user, work);

        return fave;
    }

}
