package io.sulty.gemstube.service.cloud;

import org.junit.jupiter.api.Test;
import org.springframework.web.multipart.MultipartFile;

import static org.junit.jupiter.api.Assertions.*;

class CloudServiceTest {
    private CloudService cloudService;

    @Test
    public void testUploadFile(){
        MultipartFile file=null;
        String response = cloudService.upload(file);
    }


}