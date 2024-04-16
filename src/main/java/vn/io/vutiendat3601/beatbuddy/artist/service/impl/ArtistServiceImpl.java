package vn.io.vutiendat3601.beatbuddy.artist.service.impl;

import static vn.io.vutiendat3601.beatbuddy.artist.constant.ArtistConstant.ARTIST;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import vn.io.vutiendat3601.beatbuddy.artist.dto.ArtistDto;
import vn.io.vutiendat3601.beatbuddy.artist.exception.ResourceNotFoundException;
import vn.io.vutiendat3601.beatbuddy.artist.mapper.ArtistMapper;
import vn.io.vutiendat3601.beatbuddy.artist.repository.ArtistRepository;
import vn.io.vutiendat3601.beatbuddy.artist.service.ArtistService;

@RequiredArgsConstructor
@Service
public class ArtistServiceImpl implements ArtistService {
  private final ArtistRepository artistRepo;

  @Override
  public Mono<ArtistDto> getArtist(String id) {
    return artistRepo
        .findById(id)
        .switchIfEmpty(Mono.error(new ResourceNotFoundException(ARTIST, "id", id)))
        .map(ArtistMapper::mapToArtistDto);
  }

  @Override
  public Flux<ArtistDto> getSeveralArtists(List<String> ids) {
    return Flux.fromIterable(ids)
        .flatMap(this::getArtist)
        .onErrorContinue((e, o) -> {})
        .subscribeOn(Schedulers.parallel());
  }
}
