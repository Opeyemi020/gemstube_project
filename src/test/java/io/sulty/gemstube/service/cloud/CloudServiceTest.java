package io.sulty.gemstube.service.cloud;

import io.sulty.gemstube.exceptions.MediaUploadException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
@Slf4j
class CloudServiceTest {
    @Autowired
    private CloudService cloudService;


    @Test
    public void testUploadFile(){
      Path path = Paths.get(
              "C:\\Users\\Opeyemi02\\Desktop\\GemsT\\src\\main\\resources\\asset\\MTN.jpeg");  try(var inputStream = Files.newInputStream(path);){
            MultipartFile file = new MockMultipartFile("test-image",inputStream);
            String response = cloudService.upload(file);
            assertThat(response).isNotNull();
        } catch (IOException | MediaUploadException e) {
            e.printStackTrace();
            log.error("Error:: {}", e.getMessage());
        }
    }


}