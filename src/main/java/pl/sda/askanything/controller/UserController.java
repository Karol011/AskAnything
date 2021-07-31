package pl.sda.askanything.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.askanything.entity.User;
import pl.sda.askanything.service.UserService;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}/user")
    public ResponseEntity<User> findUserById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping()
    public ResponseEntity<User> newUser(@RequestBody User newUser) {

        if (newUser.equals(null)) {
            throw new RuntimeException("You must define new user");
        } else {
            return userService.save(newUser);
        }
    }
}
