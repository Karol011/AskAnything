package pl.sda.askanything.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pl.sda.askanything.entity.Question;
import pl.sda.askanything.entity.User;
import pl.sda.askanything.service.QuestionService;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class QuestionControllerTest {


        Question question = Question.builder()
                .id(1L)
                .asker(new User(1L, "Karol", "Karolsky", "superSercretPassword", null))
                .text("Some random message")
                .build();


     ResponseEntity QUESTION = new ResponseEntity<Question>(question,HttpStatus.CREATED);

    @Mock
    private QuestionService questionService;

    @InjectMocks
    private QuestionController questionController;

    @Test
    ResponseEntity<Question> shouldCreateQuestion() {
        when(questionService.save(question)).thenReturn(ResponseEntity<Question>);


    }


}