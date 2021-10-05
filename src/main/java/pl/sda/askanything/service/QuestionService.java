package pl.sda.askanything.service;

import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import pl.sda.askanything.entity.Question;
import pl.sda.askanything.exception.EmptyQuestionException;
import pl.sda.askanything.repository.QuestionRepository;

@Service
@AllArgsConstructor
@Validated
public class QuestionService {

    private final QuestionRepository questionRepository;

    public Question save(Question question) {
            return questionRepository.save(question);
    }
}
