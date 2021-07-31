package pl.sda.askanything.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.sda.askanything.entity.User;
import pl.sda.askanything.exception.UserNotFoundException;
import pl.sda.askanything.repository.UserRepository;

import java.util.List;

@Service
@Getter
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public ResponseEntity<User> findById(Long id) {
        User user = getUserRepository()
                .findById(id)
                .orElseThrow(() -> new UserNotFoundException("user with id " + id + " not found"));
        return new ResponseEntity<>(user,
                HttpStatus.OK);
    }


    public User findByUsername(String name) {
        return userRepository.findByName(name)
                .orElseThrow(() -> new UserNotFoundException(name + " not found"));

    }

    public List<User> findAll() {
        return getUserRepository().findAll();
    }

    public ResponseEntity<User> save(User newUser) {

        User user = new User();
        user.setName(newUser.getName());
        user.setEmail(newUser.getEmail());
        user.setPassword(newUser.getPassword());
        userRepository.save(user);

        return new ResponseEntity<>(user,
                HttpStatus.CREATED);
    }

    public void deleteById(Long id) {
        getUserRepository().deleteById(id);
    }


}
