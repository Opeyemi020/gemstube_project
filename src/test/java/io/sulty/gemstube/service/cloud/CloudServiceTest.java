package io.sulty.gemstube.service.cloud;
import io.sulty.gemstube.exceptions.MediaUploadException;
import io.sulty.gemstube.utils.AppUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static io.sulty.gemstube.service.mediaService.MediaServiceTest.getTestFile;
import static io.sulty.gemstube.utils.AppUtils.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Slf4j
public
class CloudServiceTest {
    @Autowired
    private CloudService cloudService;
    @Test
    public void testUploadAudio() throws MediaUploadException{
     String response = cloudService.upload(getTestFile(AUDIO_LOCATION));
     assertNotNull(response);
    }
    @Test
    public void testUploadImage() throws MediaUploadException {

        String response = cloudService.upload(getTestFile(IMAGE_LOCATION));
        assertNotNull(response);
    }
    @Test
    public void testThatVideo() throws MediaUploadException {
        String response = cloudService.upload(getTestFile(VIDEO_LOCATION));
        assertNotNull(response);
    }
}

