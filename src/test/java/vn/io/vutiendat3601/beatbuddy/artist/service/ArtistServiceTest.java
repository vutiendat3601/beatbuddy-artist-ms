package vn.io.vutiendat3601.beatbuddy.artist.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import reactor.test.StepVerifier;

@ActiveProfiles("dev")
@SpringBootTest
public class ArtistServiceTest {
    @Test
    public void testGetSeveralTracks() {
        List<String> trackIds = List.of("xMWAIzMELhKn2Tsl", "FlTAaGabFFxhymzu", "xasdf23c", "xMWAIzMELhKn2Tsl");
        StepVerifier.create(artistService.getSeveralArtists(trackIds))
                .expectNextCount(2)
                .verifyComplete();
    }

    @Autowired
    public ArtistServiceTest(ArtistService artistService) {
        this.artistService = artistService;
    }

    private final ArtistService artistService;
}
