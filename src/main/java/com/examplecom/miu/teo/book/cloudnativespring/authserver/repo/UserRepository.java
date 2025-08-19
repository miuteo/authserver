package com.examplecom.miu.teo.book.cloudnativespring.authserver.repo;

import com.examplecom.miu.teo.book.cloudnativespring.authserver.domain.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

  Optional<User> findByUsername(String username);
}
