package io.sulty.gemstube.service.mediaService;

import io.sulty.gemstube.dtos.request.mediaRequest.UploadMediaRequest;
import io.sulty.gemstube.dtos.response.mediaResponse.UploadMediaResponse;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AllArgsConstructor
class MediaServiceTest {
//    @Autowired
    private MediaService mediaService;

    @Test
    public void testUploadMedia(){
        UploadMediaRequest mediaRequest = new UploadMediaRequest();
        UploadMediaResponse mediaResponse = mediaService.upload(mediaRequest);

    }
}