package pl.sda.askanything.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import pl.sda.askanything.entity.User;
import pl.sda.askanything.exception.UserNotFoundException;
import pl.sda.askanything.utility.MyUserDetails;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserService userService;

    public MyUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public MyUserDetails loadUserByUsername(String username) {
        User user = userService.findByUsername(username);
        if (user == null) {
            throw new UserNotFoundException("Username: " + username + " not found");
        }
        return new MyUserDetails(user);
    }
}
