package pl.sda.askanything.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.askanything.entity.Question;
import pl.sda.askanything.service.QuestionService;

@RestController
@RequestMapping("/questions")
@NoArgsConstructor
@AllArgsConstructor
public class QuestionController {

    private QuestionService questionService;

    @PostMapping()
    public ResponseEntity<Question> newQuestion(@RequestBody Question newQuestion) {

        if (newQuestion.equals(null)) {
            System.out.println("nulllll");
            //todo method throws status 500 when receiving null object
        }
        if (newQuestion.getText().equals("")) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return questionService.save(newQuestion);
        }
    }
}
