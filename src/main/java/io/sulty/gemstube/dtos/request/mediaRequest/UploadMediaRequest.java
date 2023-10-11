package io.sulty.gemstube.dtos.request.mediaRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UploadMediaRequest {

    private Long creator;
    private String title;
    private MultipartFile multipartFile;
    private String description;

}
