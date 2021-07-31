package pl.sda.askanything.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.askanything.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByName(String name);
}
