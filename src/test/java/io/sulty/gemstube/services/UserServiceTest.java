package io.sulty.gemstube.services;
import io.sulty.gemstube.dtos.request.RegisterRequest;
import io.sulty.gemstube.dtos.response.RegisterResponse;
import io.sulty.gemstube.service.RealUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private RealUserService userService;
    @Test
    public void registerTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setEmail("john@email.com");
        registerRequest.setPassword("password");

        RegisterResponse registerResponse = userService.register(registerRequest);

        assertNotNull(registerResponse);
        assertNotNull(registerResponse.getId());
    }
}