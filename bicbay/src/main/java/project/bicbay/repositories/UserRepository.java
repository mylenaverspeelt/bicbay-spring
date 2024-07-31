package project.bicbay.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.bicbay.models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
