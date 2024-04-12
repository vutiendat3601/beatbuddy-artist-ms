package vn.io.vutiendat3601.beatbuddy.artist;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import vn.io.vutiendat3601.beatbuddy.artist.util.ProfilesResolver;

@ActiveProfiles(resolver = ProfilesResolver.class)
@SpringBootTest
class ArtistServiceApplicationTests {
	@Test
	void contextLoads() {
	}
}
