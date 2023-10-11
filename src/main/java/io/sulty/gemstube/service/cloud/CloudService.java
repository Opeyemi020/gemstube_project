package io.sulty.gemstube.service.cloud;

import org.springframework.web.multipart.MultipartFile;

public interface CloudService {


    String upload(MultipartFile file);
}
