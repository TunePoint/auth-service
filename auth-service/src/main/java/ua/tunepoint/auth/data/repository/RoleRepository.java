package ua.tunepoint.auth.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.tunepoint.auth.data.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByName(String name);

    boolean existsByName(String name);
}
