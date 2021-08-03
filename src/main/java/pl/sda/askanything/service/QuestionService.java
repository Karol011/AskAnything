package pl.sda.askanything.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.sda.askanything.entity.Question;
import pl.sda.askanything.repository.QuestionRepository;

import java.time.LocalDate;

@Service
@Getter
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

    public ResponseEntity<Question> save(Question newQuestion) {

        Question question = new Question();
        question.setText(newQuestion.getText());
        question.setDate(LocalDate.now());
        question.setAsker(newQuestion.getAsker());
        questionRepository.save(question);

        return new ResponseEntity<>(question,
                HttpStatus.CREATED);
    }

}
