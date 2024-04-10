package vn.io.vutiendat3601.beatbuddy.artist.entity;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.UUID;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("artists")
public final class Artist {
    @Id
    private UUID pkId;

    private String id;

    private String urn;

    private String name;

    private Boolean isVerified = false;

    private Boolean isPublic = false;

    private String realName;

    private LocalDate birthDate;

    private String description;

    private String nationality;

    private String biography;

    private String thumbnail;

    private String background;

    private Long totalViews = 0L;

    private Long totalLikes = 0L;

    private Long totalShares = 0L;
    
    private String refCode;

    @CreatedDate
    protected ZonedDateTime createdAt;

    @LastModifiedDate
    protected ZonedDateTime updatedAt;

    @CreatedBy
    protected String createdBy;

    @LastModifiedBy
    protected String updatedBy;
}
