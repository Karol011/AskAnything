package pl.sda.askanything.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.sda.askanything.entity.Question;
import pl.sda.askanything.entity.Response;
import pl.sda.askanything.entity.User;
import pl.sda.askanything.exception.EmptyQuestionException;
import pl.sda.askanything.repository.QuestionRepository;

import java.util.List;

@ExtendWith(SpringExtension.class)
@WebMvcTest(QuestionService.class)
class QuestionServiceTest {

    @MockBean
    private QuestionRepository questionRepository;
    @MockBean
    private MyUserDetailsService myUserDetailsService;
    @InjectMocks
    private QuestionService questionService;
    Question nullQuestion = null;
    Question emptyQuestion = new Question(new User(),
            List.of(new Response()),
            "");


    @BeforeEach
    void setUp() {
        Question question = new Question(
                new User("Karol",
                        "Karolskyy",
                        "superSecretPassword",
                        null),
                null,
                "super text");
        Mockito.when(questionRepository.save(question)).thenReturn(question);
    }

    @Test
    public void shouldThrowWhenQuestionIsNull() {
        Assertions.assertThrows(EmptyQuestionException.class, () -> {
            questionService.save(nullQuestion);
        });
    }

    @Test
    public void shouldThrowWhenQuestionIsEmpty() {
        Assertions.assertThrows(EmptyQuestionException.class, () -> {
            questionService.save(emptyQuestion);
        });
    }

}