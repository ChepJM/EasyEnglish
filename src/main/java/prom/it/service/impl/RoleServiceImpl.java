package prom.it.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prom.it.entity.Vocabulary;
import prom.it.entity.security.Role;
import prom.it.repository.RoleRepository;
import prom.it.repository.VocabularyRepository;
import prom.it.service.RoleService;
import prom.it.service.VocabularyService;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role addRole(Role role) {
        return roleRepository.saveAndFlush(role);
    }

    @Override
    public Boolean deleteRole(Long id) {
        try {
            roleRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Role getById(Long id) {
        Optional<Role> role = roleRepository.findById(id);
        return role.orElseGet(Role::new);
    }

    @Override
    public Role updateRole(Role role) {
        return roleRepository.saveAndFlush(role);
    }

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }
}
