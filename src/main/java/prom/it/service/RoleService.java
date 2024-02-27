package prom.it.service;

import prom.it.entity.Vocabulary;
import prom.it.entity.security.Role;

import java.util.List;

public interface RoleService {

    Role addRole(Role role);
    Boolean deleteRole(Long id);
    Role getById(Long id);
    Role updateRole(Role role);
    List<Role> getAll();

}
