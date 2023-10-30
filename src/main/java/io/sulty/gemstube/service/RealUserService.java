package io.sulty.gemstube.service;

import io.sulty.gemstube.dtos.request.RegisterRequest;
import io.sulty.gemstube.dtos.response.RegisterResponse;
import io.sulty.gemstube.exceptions.GemsTubeException;
import io.sulty.gemstube.model.User;
import io.sulty.gemstube.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RealUserService implements UserService{
    private final UserRepository userRepository;

    public RegisterResponse register(RegisterRequest request){
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        User savedUser = userRepository.save(user);

        return new RegisterResponse(savedUser.getId());

    }

    @Override
    public User getUserById(Long creatorId) throws GemsTubeException {
        return userRepository.findById(creatorId).orElseThrow(()-> new GemsTubeException(String.format("user with id %d not found", creatorId)));
    }
}
