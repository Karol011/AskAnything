package pl.sda.askanything.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.askanything.entity.Question;
import pl.sda.askanything.exception.EmptyQuestionException;
import pl.sda.askanything.repository.QuestionRepository;

@Service
@AllArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

    public Question save(Question question) {
        if (question == null) {
            throw new EmptyQuestionException("Question cannot be null");
        } else if (question.getText().equals("")) {
            throw new EmptyQuestionException("You cannot add empty question");
        } else
            return questionRepository.save(question);
    }
}
