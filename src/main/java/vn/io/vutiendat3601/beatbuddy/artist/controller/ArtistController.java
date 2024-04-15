package vn.io.vutiendat3601.beatbuddy.artist.controller;

import static vn.io.vutiendat3601.beatbuddy.artist.constant.ArtistConstant.ID_LENGTH;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import vn.io.vutiendat3601.beatbuddy.artist.dto.ArtistDto;
import vn.io.vutiendat3601.beatbuddy.artist.service.ArtistService;

@RequestMapping("v1/artists")
@RequiredArgsConstructor
@RestController
public class ArtistController {
  private final ArtistService artistService;

  @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<ResponseEntity<ArtistDto>> getArtist(
      @Length(
              min = ID_LENGTH,
              max = ID_LENGTH,
              message = "Artist ID must be " + ID_LENGTH + " characters")
          @PathVariable
          String id) {

    return artistService.getArtist(id).map(ResponseEntity::ok);
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<ResponseEntity<List<ArtistDto>>> getSeveralArtists(
      @Size(min = 1, max = 50, message = "ids size must be in range [1,50]")
          @NotEmpty(message = "ids must not be empty")
          @RequestParam
          List<String> ids) {

    return artistService.getSeveralArtists(ids).collectList().map(ResponseEntity::ok);
  }
}
