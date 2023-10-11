package io.sulty.gemstube.service.mediaService;

import io.sulty.gemstube.dtos.request.mediaRequest.UploadMediaRequest;
import io.sulty.gemstube.dtos.response.mediaResponse.UploadMediaResponse;
import io.sulty.gemstube.exceptions.MediaUploadException;
import io.sulty.gemstube.service.cloud.CloudService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class GemstubeMediaService implements MediaService{
    private final CloudService cloudService;

    @Override
    public UploadMediaResponse upload(UploadMediaRequest mediaRequest) throws MediaUploadException {
       String response = cloudService.upload(mediaRequest.getMultipartFile());
        Media media = new Media();
        return null;
    }
}
