package prom.it.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import prom.it.entity.security.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
