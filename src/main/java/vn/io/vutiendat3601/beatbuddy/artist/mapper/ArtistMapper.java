package vn.io.vutiendat3601.beatbuddy.artist.mapper;

import vn.io.vutiendat3601.beatbuddy.artist.dto.ArtistDto;
import vn.io.vutiendat3601.beatbuddy.artist.entity.Artist;

public interface ArtistMapper {
    static ArtistDto mapToArtistDto(Artist artist) {
        ArtistDto artistDto = new ArtistDto();
        return mapToArtistDto(artist, artistDto);
    }

    static ArtistDto mapToArtistDto(Artist artist, ArtistDto artistDto) {
        artistDto.setId(artist.getId());
        artistDto.setUrn(artist.getUrn());
        artistDto.setName(artist.getName());
        artistDto.setIsVerified(artist.getIsVerified());
        artistDto.setIsPublic(artist.getIsPublic());
        artistDto.setRealName(artist.getRealName());
        artistDto.setBirthDate(artist.getBirthDate());
        artistDto.setDescription(artist.getDescription());
        artistDto.setNationality(artist.getNationality());
        artistDto.setBiography(artist.getBiography());
        artistDto.setThumbnail(artist.getThumbnail());
        artistDto.setBackground(artist.getBackground());
        artistDto.setTotalViews(artist.getTotalViews());
        artistDto.setTotalLikes(artist.getTotalLikes());
        artistDto.setTotalShares(artist.getTotalShares());
        return artistDto;
    }
}
