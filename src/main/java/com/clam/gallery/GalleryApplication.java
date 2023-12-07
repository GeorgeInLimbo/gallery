package com.clam.gallery;

import com.clam.gallery.models.Artwork;
import com.clam.gallery.models.Role;
import com.clam.gallery.models.User;
import com.clam.gallery.repositories.ArtworkRepository;
import com.clam.gallery.repositories.UserRepository;
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
	private UserRepository userRepo;

	public static void main(String[] args) {
		SpringApplication.run(GalleryApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			Artwork work1 = Artwork.builder()
				// .artworkId(UUID.fromString("123e4567-e89b-12d3-a456-426655440000"))
				.title("Beginnings")
				.medium("Acrylics")
				//.creationDate(new Date(2023, 12, 6))
				.artist(UUID.fromString("0550fcef-a1d7-403f-9bed-3981e0362e05"))
				.build();

			artworkRepo.save(work1);

			User user1 = User.builder()
				.firstName("George")
				.lastName("Clam")
				.email("george@email.com")
				.role(Role.valueOf("USER"))
				.password("password")
				.build();

			userRepo.save(user1);
		};
	}

}
