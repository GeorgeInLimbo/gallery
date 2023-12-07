package com.clam.gallery;

import com.clam.gallery.models.*;
import com.clam.gallery.repositories.ArtistRepository;
import com.clam.gallery.repositories.ArtworkRepository;
import com.clam.gallery.repositories.FavoritedRepository;
import com.clam.gallery.repositories.GalleryUserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class GalleryApplication {

	@Autowired
	private ArtworkRepository artworkRepo;

	@Autowired
	private GalleryUserRepository userRepo;

	@Autowired
	private ArtistRepository artistRepo;

	@Autowired
	private FavoritedRepository faveRepo;

	public static void main(String[] args) {
		SpringApplication.run(GalleryApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			Artwork work1 = Artwork.builder()
				.title("Beginnings")
				.medium("Acrylics")
				.artist(UUID.fromString("0550fcef-a1d7-403f-9bed-3981e0362e05"))
				.build();

			artworkRepo.save(work1);

			GalleryUser user1 = GalleryUser.builder()
				.firstName("George")
				.lastName("Clam")
				.email("george@email.com")
				.role(Role.valueOf("USER"))
				.password("password")
				.build();

			userRepo.save(user1);

			Artist artist1 = Artist.builder()
				.user(UUID.fromString("54f20762-0e2d-4afe-a081-be5e4a66976e"))
				.description("This is a test Artist.")
				.build();

			artistRepo.save(artist1);

			FavoritedEntity fave1 = FavoritedEntity.builder()
				.user(userRepo.findById(UUID.fromString("54f20762-0e2d-4afe-a081-be5e4a66976e"))
					.orElseThrow(() -> new EntityNotFoundException("This user could not be found.")))
				.artwork(artworkRepo.findById(UUID.fromString("0550fcef-a1d7-403f-9bed-3981e0362e05"))
					.orElseThrow(() -> new EntityNotFoundException("This artwork could not be found.")))
				.build();

			faveRepo.save(fave1);
		};
	}

}
