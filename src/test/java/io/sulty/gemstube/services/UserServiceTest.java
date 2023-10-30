package io.sulty.gemstube.services;
import io.sulty.gemstube.dtos.request.RegisterRequest;
import io.sulty.gemstube.dtos.response.RegisterResponse;
import io.sulty.gemstube.exceptions.GemsTubeException;
import io.sulty.gemstube.model.User;
import io.sulty.gemstube.service.RealUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private RealUserService userService;
    private RegisterRequest registerRequest;
    @BeforeEach
            public void setUp(){
        registerRequest = new RegisterRequest();
        registerRequest.setEmail("laycon122@gmail.com");
        registerRequest.setPassword("password");

    }
    @Test
    public void registerTest(){
        registerRequest = new RegisterRequest();
        RegisterResponse registerResponse = userService.register(registerRequest);

        assertNotNull(registerResponse);
        assertNotNull(registerResponse.getId());
    }
    @Test
    public void testGetUserById() throws GemsTubeException {
        var response = userService.register(registerRequest);
        User user = userService.getUserById(response.getId());
        assertThat(user).isNotNull();
    }
}