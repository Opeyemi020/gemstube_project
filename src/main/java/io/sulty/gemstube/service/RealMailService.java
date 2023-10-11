package io.sulty.gemstube.service;

import io.sulty.gemstube.config.MailConfig;
import io.sulty.gemstube.dtos.request.EmailRequest;
import io.sulty.gemstube.dtos.response.EmailResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.net.URI;

import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Service
@RequiredArgsConstructor
public class RealMailService implements MailService{
    private final MailConfig mailConfig;
    @Override
    public EmailResponse sendMail(EmailRequest emailRequest){
        RestTemplate restTemplate = new RestTemplate();
        org.springframework.http.HttpHeaders httpHeaders = new org.springframework.http.HttpHeaders();
        httpHeaders.setContentType(APPLICATION_JSON);
        httpHeaders.set("accept",APPLICATION_JSON_VALUE);
        httpHeaders.set("api-key",mailConfig.getMailApiKey());
        HttpEntity<EmailRequest> requestEntity = new RequestEntity<>(emailRequest,httpHeaders,POST, URI.create(""));
        ResponseEntity<EmailResponse> response = restTemplate.postForEntity(mailConfig.getBrevoMailUrl(),
                requestEntity, EmailResponse.class);
        var emailResponse = response.getBody();

        emailResponse.setCode(response.getStatusCode().value());
        return emailResponse;

    }
}
