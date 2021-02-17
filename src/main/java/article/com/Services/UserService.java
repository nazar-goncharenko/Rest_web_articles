package article.com.Services;


import article.com.Models.Role;
import article.com.Models.User;
import article.com.Reposetories.RoleRepository;
import article.com.Reposetories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    public User getUserByEmail(String email){
        return userRepository.getByEmail(email);
    }

    public User createUser(User user){
        if (userRepository.getByEmail(user.getEmail()) == null) {
            Role role = new Role(1L, "ROLE_USER");
            roleRepository.save(role);
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            user.setRoles(Collections.singleton(role));
            return userRepository.save(user);
        }
        return null;
    }

    public User createModer(User user){
        if (userRepository.getByEmail(user.getEmail()) == null) {
            Role role = new Role(1L, "ROLE_MODERATOR");
            roleRepository.save(role);
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            user.setRoles(Collections.singleton(role));
            return userRepository.save(user);
        }
        return null;
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        if (getUserByEmail(s) != null){
            return getUserByEmail(s);
        }
        throw new UsernameNotFoundException("Email not found");
    }
}
