package shop.janghj.mytrip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.janghj.mytrip.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
