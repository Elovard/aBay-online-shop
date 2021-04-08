package by.tms.storeproject.service;

import by.tms.storeproject.entity.User;
import by.tms.storeproject.storage.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public void save(User user){
        userRepository.save(user);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> byUserName = userRepository.findUserByUsername(username);
        if(byUserName.isPresent()){
            User user = byUserName.get();
            UserDetails userDetails = org.springframework.security.core.userdetails.User.builder()
                    .username(user.getUsername())
                    .password(user.getPassword())
                    .authorities(user.getUserRoles())
                    .build();
            return userDetails;
        }
        throw new UsernameNotFoundException("User " + username + " not found!");
    }
}
