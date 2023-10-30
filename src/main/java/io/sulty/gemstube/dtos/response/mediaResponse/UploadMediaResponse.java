package io.sulty.gemstube.dtos.response.mediaResponse;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
@Getter @Setter
public class UploadMediaResponse {

    private String message;
    @Id
    private Long mediaId;
}
