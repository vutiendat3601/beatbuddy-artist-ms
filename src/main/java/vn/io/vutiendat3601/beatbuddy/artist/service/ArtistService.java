package vn.io.vutiendat3601.beatbuddy.artist.service;

import java.util.List;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import vn.io.vutiendat3601.beatbuddy.artist.dto.ArtistDto;

public interface ArtistService {
  Mono<ArtistDto> getArtist(String id);

  Flux<ArtistDto> getSeveralArtists(List<String> ids);
}
