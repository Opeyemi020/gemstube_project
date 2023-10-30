package io.sulty.gemstube.service.mediaService;

import io.sulty.gemstube.dtos.request.mediaRequest.UploadMediaRequest;
import io.sulty.gemstube.dtos.response.mediaResponse.UploadMediaResponse;
import io.sulty.gemstube.exceptions.GemsTubeException;

public interface MediaService {
    UploadMediaResponse upload(UploadMediaRequest mediaRequest) throws GemsTubeException;
}
