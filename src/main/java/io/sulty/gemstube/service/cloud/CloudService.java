package io.sulty.gemstube.service.cloud;

import io.sulty.gemstube.exceptions.MediaUploadException;
import org.springframework.web.multipart.MultipartFile;

public interface CloudService {


    String upload(MultipartFile file) throws MediaUploadException;
}
