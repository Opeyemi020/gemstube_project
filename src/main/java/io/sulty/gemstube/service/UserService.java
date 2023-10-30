package io.sulty.gemstube.service;

import io.sulty.gemstube.exceptions.GemsTubeException;
import io.sulty.gemstube.model.User;

public interface UserService {
    User getUserById(Long creatorId) throws GemsTubeException;
}
