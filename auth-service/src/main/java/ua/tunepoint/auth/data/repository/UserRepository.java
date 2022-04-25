package ua.tunepoint.auth.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.tunepoint.auth.data.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);
}
