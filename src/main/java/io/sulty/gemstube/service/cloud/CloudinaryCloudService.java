package io.sulty.gemstube.service.cloud;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import io.sulty.gemstube.exceptions.MediaUploadException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
@Slf4j
@AllArgsConstructor
public class CloudinaryCloudService implements CloudService {
    private final Cloudinary cloudinary;
    @Override
    public String upload(MultipartFile file) throws MediaUploadException {
        try {
            Map<?, ?> uploadResponse = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap("resource_type", "auto"));
            log.info("upload response-->{}", uploadResponse);
            String image_Url = (String) uploadResponse.get("secure_url");
            return image_Url;
        } catch (IOException theException) {
            throw new MediaUploadException(theException.getMessage());
        }
    }
}
