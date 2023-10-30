package io.sulty.gemstube.service.mediaService;

import io.sulty.gemstube.dtos.request.mediaRequest.UploadMediaRequest;
import io.sulty.gemstube.dtos.response.mediaResponse.UploadMediaResponse;
import io.sulty.gemstube.exceptions.GemsTubeException;
import io.sulty.gemstube.model.Media;
import io.sulty.gemstube.model.User;
import io.sulty.gemstube.repository.MediaRepository;
import io.sulty.gemstube.service.UserService;
import io.sulty.gemstube.service.cloud.CloudService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import static io.sulty.gemstube.config.ResponseConfig.MEDIA_UPLOAD_SUCCESSFUL;

@Service
@AllArgsConstructor

public class GemstubeMediaService implements MediaService{
    private final CloudService cloudService;
    private final MediaRepository mediaRepository;
    private final UserService userService;
    private final ModelMapper modelMapper;


    @Override
    public UploadMediaResponse upload(UploadMediaRequest mediaRequest) throws GemsTubeException {
        User user = userService.getUserById(mediaRequest.getCreatorId());
       String response_Url = cloudService.upload(mediaRequest.getMultipartFile());

        ModelMapper mapper = new ModelMapper();

        mapper.map(mediaRequest,Media.class);
        Media media = new Media();
        media.setUrl(response_Url);
        media.setUploader(user);

        Media savedMEDIA = mediaRepository.save(media);
        return buildUploadMediaResponse(savedMEDIA);
    }
    private static UploadMediaResponse buildUploadMediaResponse(Media savedMEDIA) {
        UploadMediaResponse response = new UploadMediaResponse();
        response.setMessage(MEDIA_UPLOAD_SUCCESSFUL);
        response.setMediaId(savedMEDIA.getId());
        return response;
    }
}