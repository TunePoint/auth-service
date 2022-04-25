package ua.tunepoint.auth.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.tunepoint.auth.data.entity.ConfirmationCode;

public interface ConfirmationCodeRepository extends JpaRepository<ConfirmationCode, Long> {
}
