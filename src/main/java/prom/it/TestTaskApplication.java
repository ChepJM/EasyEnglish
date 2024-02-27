package prom.it;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import prom.it.entity.security.Role;
import prom.it.entity.security.User;
import prom.it.repository.RoleRepository;
import prom.it.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class TestTaskApplication {

    private static UserRepository userRepository;

    private static RoleRepository roleRepository;


    @Autowired
    public void setRoleRepository(RoleRepository roleRepository){
        TestTaskApplication.roleRepository = roleRepository;
    }

    @Autowired
    public void setSomeThing(UserRepository userRepository){
        TestTaskApplication.userRepository = userRepository;
    }


    public static void main(String[] args) {
        SpringApplication.run(TestTaskApplication.class, args);

        Role role = new Role();
        role.setName("Admin");
        roleRepository.save(role);

        User user = new User();
        user.setUsername("ChepJM");
        user.setRoles(Set.of(role));
        userRepository.save(user);

    }

}
