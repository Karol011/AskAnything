package pl.sda.askanything.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.askanything.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
