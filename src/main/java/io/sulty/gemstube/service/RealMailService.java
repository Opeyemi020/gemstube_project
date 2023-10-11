package io.sulty.gemstube.service;

import io.sulty.gemstube.dtos.request.EmailRequest;
import io.sulty.gemstube.dtos.response.EmailResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import static org.springframework.http.MediaType.APPLICATION_JSON;
@Service
public class RealMailService implements MailService{
    @Override
    public EmailResponse sendMail(EmailRequest emailRequest){
        RestTemplate restTemplate = new RestTemplate();
        org.springframework.http.HttpHeaders httpHeaders = new org.springframework.http.HttpHeaders();
        httpHeaders.setContentType(APPLICATION_JSON);
        httpHeaders.setAccept(List.of(APPLICATION_JSON));
        httpHeaders.set("api-key","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");
        ResponseEntity<EmailResponse> response = restTemplate.postForEntity("https://api.brevo.com/v3/smtp/email",
                emailRequest, EmailResponse.class, httpHeaders);

    }
}
