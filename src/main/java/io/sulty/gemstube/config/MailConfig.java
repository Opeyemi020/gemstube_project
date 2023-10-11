package io.sulty.gemstube.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class MailConfig {
    @Value("${brevo.mail.url}")
    private String mailApiKey;

    @Value("${mail.api.key}")
    private String brevoMailUrl;
}
