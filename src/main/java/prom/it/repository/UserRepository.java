package prom.it.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import prom.it.entity.security.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
