package vn.io.vutiendat3601.beatbuddy.artist.repository;

import java.util.UUID;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;
import vn.io.vutiendat3601.beatbuddy.artist.entity.Artist;

public interface ArtistRepository extends ReactiveCrudRepository<Artist, UUID> {
  Mono<Artist> findById(String id);
}
