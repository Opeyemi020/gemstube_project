package io.sulty.gemstube.service.mediaService;

import io.sulty.gemstube.dtos.request.RegisterRequest;
import io.sulty.gemstube.dtos.request.mediaRequest.UploadMediaRequest;
import io.sulty.gemstube.dtos.response.mediaResponse.UploadMediaResponse;
import io.sulty.gemstube.exceptions.GemsTubeException;
import io.sulty.gemstube.service.RealUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static io.sulty.gemstube.utils.AppUtils.IMAGE_LOCATION;
import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
public
class MediaServiceTest {
    @Autowired
    private MediaService mediaService;
    @Autowired
    private RealUserService userService;


    @Test
    public void testUploadMedia() throws GemsTubeException{
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setEmail("test@gmail.com");
        registerRequest.setPassword("password");
        var registerResponse=userService.register(registerRequest);
        UploadMediaRequest mediaRequest = new UploadMediaRequest();
        mediaRequest.setCreatorId(registerResponse.getId());
        mediaRequest.setTitle("this is our test media");
        mediaRequest.setMultipartFile(getTestFile(IMAGE_LOCATION));
        UploadMediaResponse mediaResponse = mediaService.upload(mediaRequest);
        assertThat(mediaResponse).isNotNull();

    }
    public static MultipartFile getTestFile(String fileLOCATION) {
        Path path = Paths.get(fileLOCATION);
        try (var inputStream = Files.newInputStream(path)) {
            MultipartFile file = new MockMultipartFile("test-image", inputStream);
            return file;

        } catch (IOException exception) {
            exception.printStackTrace();
            throw new RuntimeException(exception);
        }
    }
}