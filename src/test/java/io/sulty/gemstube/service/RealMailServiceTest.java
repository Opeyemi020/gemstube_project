package io.sulty.gemstube.service;

import io.sulty.gemstube.dtos.request.EmailRequest;
import io.sulty.gemstube.dtos.request.Recipient;
import io.sulty.gemstube.dtos.response.EmailResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

    @SpringBootTest
    public class RealMailServiceTest {
        @Autowired
        private  MailService mailService;
        @Test
        public void testSendEmail(){
            Recipient recipient = new Recipient();
            recipient.setEmail("ladekolaolokode@yahoo.com");
            recipient.setName("ADEKOLA LATTEFAT MOMMY");
            List<Recipient> recipients = List.of(
                    recipient
            );

            EmailRequest emailRequest = new  EmailRequest();
            emailRequest.setRecipients(recipients);
            emailRequest.setHtmlContent("<p>we are testing our app</p>");
            emailRequest.setSubject("welcome to our SultyTube streaming application....");

            EmailResponse response  =mailService.sendMail(emailRequest);
            assertNotNull(response);
            assertNotNull(response.getMessageId());
            assertNotNull(response.getCode());
            assertEquals(201, response.getCode());
    }

}