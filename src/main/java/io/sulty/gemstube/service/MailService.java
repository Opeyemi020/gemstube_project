package io.sulty.gemstube.service;

import io.sulty.gemstube.dtos.request.EmailRequest;
import io.sulty.gemstube.dtos.response.EmailResponse;

public interface MailService {
    EmailResponse sendMail(EmailRequest emailRequest);
}
