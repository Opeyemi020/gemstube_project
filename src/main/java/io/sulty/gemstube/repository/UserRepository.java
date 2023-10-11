package io.sulty.gemstube.repository;

import io.sulty.gemstube.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {


}
